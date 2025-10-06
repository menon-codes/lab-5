package usecase;

import api.GradeDataBase;
import entity.Grade;
import entity.Team;

/**
 * GetAverageGradeUseCase class.
 */
public final class GetAverageGradeUseCase {
    private final GradeDataBase gradeDataBase;

    public GetAverageGradeUseCase(GradeDataBase gradeDataBase) {
        this.gradeDataBase = gradeDataBase;
    }

    /**
     * Get the average grade for a course across your team.
     * @param course The course.
     * @return The average grade.
     */
    public float getAverageGrade(String course) {
        // Call the API to get usernames of all your team members
        float sum = 0;
        int count = 0;
        final Team team = gradeDataBase.getMyTeam();

        if (team == null || team.getMembers() == null) {
            return 0;
        }

        for (String member : team.getMembers()) {
            try {
                Grade gradeObj = gradeDataBase.getGrade(member, course);
                float gradeValue = gradeObj.getGrade();
                sum += gradeValue;
                count++;
            } catch (Exception e) {
                System.out.println("Error fetching grade for " + member);
                e.printStackTrace();
            }
        }

        if (count == 0) {
            return 0;
        }
        return sum / count;
    }
}
