import java.util.Scanner;
public class Examiner {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of Student:");
        int length = s.nextInt();
        String[] name = new String[length];
        String[] gender = new String[length];
        int[] myanmarMark = new int[length];
        int[] mathMark = new int[length];
        int[] englishMark = new int[length];
        int[] total = new int[length];
        String[] result = new String[length];
        int passCount = 0, failCount = 0, allTotal = 0, totalMyanmar = 0, totalMath = 0, totalEnglish = 0, highest = 0;
        String student = null;
        for (int i = 0; i < length; i++) {
            switch (i) {
                case 0:
                    System.out.println("Enter" + (i + 1) + "st" + "Student name");
                    break;
                case 1:
                    System.out.println("Enter" + (i + 1) + "nd" + "Student name");
                    break;
                case 2:
                    System.out.println("Enter" + (i + 1) + "rd" + "Student name");
                    break;
                default:
                    System.out.println("Enter" + (i + 1) + "th" + "Student name");
                    break;
            }
            name[i] = s.next();
            System.out.println("Enter Gender (M/F)");
            gender[i] = s.next();
            if (gender[i].equals("M")) {
                System.out.println("Enter Mg" + name[i] + "'s myanmar mark");
            } else System.out.println("Enter Ma" + name[i] + "'s myanmar mark");
            myanmarMark[i] = s.nextInt();
            if (gender[i].equals("M")) {
                System.out.println("Enter Mg" + name[i] + "'s Math mark");
            } else System.out.println("Enter Ma" + name[i] + "'s Math mark");
            mathMark[i] = s.nextInt();
            if (gender[i].equals("M")) {
                System.out.println("Enter Mg" + name[i] + "'s English mark");
            } else System.out.println("Enter Ma" + name[i] + "'s English mark");
            englishMark[i] = s.nextInt();
            total[i] = myanmarMark[i] + englishMark[i] + mathMark[i];
            if (myanmarMark[i] < 40 || mathMark[i] < 40 || englishMark[i] < 40) {
                result[i] = "(Failed)";
                failCount++;
            } else {
                result[i] = "(Passed)";
                passCount++;
            }
            allTotal += total[i];
            totalMyanmar += myanmarMark[i];
            totalMath += mathMark[i];
            totalEnglish += englishMark[i];
            if (gender[i].equals("M")) {
                System.out.println("Enter Mg" + name[i] + total[i] + result[i]);
            } else {
                System.out.println("Enter Ma" + name[i] + total[i] + result[i]);
            }
            if (total[i] == 0) {
                highest = total[i];
            } else {
                if (total[i] > highest)
                    highest = total[i];
                student = name[i];
            }
            if (passCount == length) {
                System.out.println("All students passed the exam");
            } else {
                System.out.println(passCount + "out of" + length + "students passed the exam");
            }
            System.out.println("Passed rate" + "\t" + (passCount / length) * 100 + "%");
            System.out.println("Average Mark(all subject)" + "\t" + allTotal / (length * 3));
            System.out.println("Average Myanmar mark" + "\t" + totalMyanmar / length);
            System.out.println("Average Math mark" + "\t" + totalMath / length);
            System.out.println("Average english mark" + "\t" + totalEnglish / length);
            System.out.println(student + "got highest mark with" + highest);
            System.out.println("Student Summery");
            System.out.println("Name" + "\t" + "Gender" + "\t" + "Myanmar" + "\t" + "Math" + "\t" + "English" + "\t" + "Total" + "\t" +
                    "Passed/failed");
            System.out.println("====" + "\t" + "======" + "\t" + "=======" + "\t" + "====" + "\t" + "=======" + "\t" + "=====" +
                    "==========");
            for (int j = 0; j < length; j++) {
                System.out.println(name[j] + "\t" + gender[j] + "\t" + myanmarMark[j] + "\t" + mathMark[j] + "\t" + englishMark[j] + "\t"
                        + total[j] + "\t" + result[j]);
            }
        }
    }
}