package leedcode;

public class longestPalindrome {

    static int solution(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[][]array = new int[m][n];//定义：存放的数据是从开始点到这个点的最小数据和
        //特殊情况直接返回
        if(m<=0 || n <=0) return 0;
        //初始化
        array[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            array[i][0] = grid[i][0]+array[i-1][0];
        }
        for(int j = 1; j < n; j++){
            array[0][j]= grid[0][j]+array[0][j-1];
        }
        //推算关系
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                array[i][j] = Math.min(array[i - 1][j], array[i][j-1])+grid[i][j];

            }
        }
        return array[m-1][n-1];

    }
    static int solution1(int n){
        int[]dp = new int[n+1]; //定义
        if(n <= 1){
            return n;
        }
        if(n <=2){
            return 2;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];

    }
    static int solution2(int m, int n){
        //定义
        int[][]dp = new int[m][n];
        //特殊条件直接返回
        if(m <= 0|| n <= 0) return 0;
        //初始化
        for (int i = 0; i < m; i++) {
            dp[m][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][n] = 1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[m][n] = dp[m][n-1]+dp[m-1][n];
            }
        }
        return dp[m-1][n-1];
    }
    static int solution3(String word1, String word2){
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1]; //定义：word1前m个字符转化为word2前n的字符，转换共需要dp[m][n]步。
        //特殊情况直接返回
        if(word1.equals(word2)) return 0;
        //初始值:
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        //推算关系：
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j], dp[i][j-1]))+1;
                }
            }
        }
        return dp[m][n];
    }
    static int solution4(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[][]dp = new int[m][n]; //定义：表示到m，n的位置共有dp[m][n]条走法
        //特殊情况直接返回
        if(m==0) return 0;
        //初始化
        for (int i = 0; i < m && grid[i][0]==0; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n && grid[0][j]==0; j++) {
            dp[0][j] = 1;
        }
        //  推算关系
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(grid[i][j]!=1){
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m-1][n-1];

    }
    static String solution5(String s){
        if(s==null||s.length()<=1) return s;
        String[] dp = new String[s.length()];
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;
            int currentmax = 0;
            while(left-1>=0 && s.charAt(left-1)==s.charAt(i)){
                left--;
                currentmax++;
            }
            while(right+1<s.length() && s.charAt(right+1) == s.charAt(i)){
                right++;
                currentmax++;
            }
            while(left-1>=0 && right+1 <s.length() && s.charAt(left-1)==s.charAt(right+1)){
                right++;
                left--;
                currentmax+=2;
            }
            if(currentmax>=result.length()){
                result =  s.substring(left, right+1);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(solution5("abcbbba"));
    }
}
