import java.util.Scanner;
import java.util.jar.JarOutputStream;

public class ScoreMaster {
    public static void main(String[] args) {
        int YuWenIndex = 0;
        int ShuXueIndex = 1;
        int WaiYuIndex = 2;
        int WuLiIndex = 3;
        int HuaXueIndex = 4;
        int ShengWuIndex = 5;
        int totalScoreCount = 6;

        String[] names = new String[totalScoreCount];
        names[YuWenIndex] = "语文";
        names[ShuXueIndex] = "数学";
        names[WaiYuIndex] = "外语";
        names[WuLiIndex] = "物理";
        names[HuaXueIndex] = "化学";
        names[ShengWuIndex] = "生物";

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入共有多少年的成绩");
        int yearCount = scanner.nextInt();
        double[][] scores = new double[yearCount][totalScoreCount];
        for (int i = 0; i < yearCount; i++){
            for (int j = 0; j < totalScoreCount; j++){
                scores[i][j] = 80 + Math.random() * 20;
                System.out.println("第"+(i + 1)+ "年" +names[j] + "成绩为："+ scores[i][j]);
            }
        }

        boolean count = true;
        while(count){
            System.out.println("请选择要进行的操作：");
            System.out.println("1：求某年最好的成绩\n"+
                    "2:求某年的平均成绩\n"+
                    "3:求所有年份最好的成绩\n" +
                    "4:求某门课历年最好成绩");
            int oprtId = scanner.nextInt();
            int year = 0;
            switch(oprtId){
                case 1:
                    System.out.println("请输入要计算第几年的最好成绩");
                    year = scanner.nextInt();
                    if (year <= 0 || yearCount <year ){
                        System.out.println("非法的年份："+year);
                        count = false;
                        break;
                    }
                    year = year - 1;
                    int bestOfYearScoreId = 0;
                    for (int i= 1; i < totalScoreCount; i++){
                        if (scores[year][bestOfYearScoreId] < scores[year][i]){
                            bestOfYearScoreId = i;
                        }
                    }

                    System.out.println("第"+(year +1)+"年成绩最好的科目为"
                            +names[bestOfYearScoreId]+ ",成绩为"
                            +scores[year][bestOfYearScoreId]);
                    break;
                case 2:
                    System.out.println("请输入要计算第几年的平均成绩");
                    year = scanner.nextInt();
                    if(year <= 0 || yearCount < year ){
                        System.out.println("非法的年份："+year);
                        count = false;
                        break;
                    }

                    year = year - 1;
                    double totalCountForAvg = 0;
                    for (int i = 0; i<totalScoreCount;i++){
                        totalCountForAvg += scores[year][i];
                    }
                    double avgOfYear = totalCountForAvg / totalScoreCount;
                    System.out.println("第" + (year + 1)+ "年的平均成绩为"+ avgOfYear);
                    break;

                case 3:
                    int bestYear = 0;
                    int bestScore = 0;

                    for (int i = 0; i<yearCount; i ++){
                        for (int j = 0; j < totalScoreCount; j++){
                            if(scores[bestYear][bestScore]<scores[i][j]){
                                bestYear = i;
                                bestScore = j;
                            }
                        }
                    }

                    System.out.println("所有年度最好成绩为第" +(bestYear + 1)+"年的" +
                            names[bestScore]+"成绩为"+scores[bestYear][bestScore]);
                    break;

                case 4:
                    System.out.println("请输入科目编号");
                    int subjectId = scanner.nextInt();
                    if(subjectId <= 0 || totalScoreCount < subjectId){
                        count = false;
                        break;
                    }

                    subjectId = subjectId - 1;
                    year = 0;
                    for (int i = 1; i < yearCount ; i ++){
                        if (scores[year][subjectId] < scores[i][subjectId]){
                            year = i;
                        }
                    }
                    System.out.println("第"+ (year + 1) + "年度" + names[subjectId]+
                            "成绩最好，为"+ scores[year][subjectId]);
                    break;

                default :
                    count = false;
                    System.out.println("不支持"+oprtId + "程序结束");

            }
        }
    }
}
