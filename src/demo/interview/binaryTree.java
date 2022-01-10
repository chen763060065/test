package demo.interview;

import apple.laf.JRSUIUtils;
import sun.lwawt.macosx.CSystemTray;

import javax.swing.tree.TreeNode;
import java.util.*;
import java.util.stream.Collectors;

class Treenode{
    int value;
    Treenode left;
    Treenode right;
    public Treenode(int value){
        this.value = value;
    }

    public Treenode(int value, Treenode left, Treenode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

public class binaryTree{

    public static List<Integer> inorderTraversal1(Treenode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> output = new ArrayList<>();
        output.addAll(inorderTraversal1(root.left));
        output.add(root.value);
        output.addAll(inorderTraversal1(root.right));
        Collections.sort(output);
        return output;
    }
    public static List<Integer> inorderTraversal2(Treenode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> output = new ArrayList<>();
        Treenode node = root;
        Stack<Treenode> stack = new Stack<>();
        while(node!=null||!stack.isEmpty()){
            while(node!=null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            output.add(node.value);
            node = node.right;
        }
        return output;
    }
    public static int maxDepth(Treenode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth((root.right))) + 1;
    }
    public static Treenode invertTree(Treenode root) {
        if(root==null) return root;
        swap(root);
        invertTree(root.left);
        invertTree((root.right));
        return root;
    }
    public static void swap(Treenode root){
        Treenode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
    public static String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char tmp = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(tmp);
            }
            else{
                while(!stack.isEmpty()&& tmp<stack.peek()&& s.substring(i).indexOf(stack.peek())!=-1){
                    stack.pop();
                }
                stack.push(tmp);
            }
        }
        char[] output = new char[stack.size()];
        for(int i = stack.size()-1; i>=0; i--){
            output[i]=stack.pop();
        }
        return output.toString();
    }
    public static int[] nextGreaterElements(int[] nums) {
        //边界判断
        if(nums == null || nums.length <= 1) {
            return new int[]{-1};
        }
        int size = nums.length;
        int[] result = new int[size];//存放结果
        Arrays.fill(result,-1);//默认全部初始化为-1
        Stack<Integer> stack= new Stack<>();//栈中存放的是nums中的元素index
        for(int i = 0; i < 2*size; i++) {
            while(!stack.isEmpty()&&stack.peek()<nums[i%size]){
                int index = stack.pop();
                result[index] = nums[i%size];
            }
            stack.push(i%size);
        }
        return result;
    }
    public static int getMaxArea(int[] heights) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] new_heights = new int[heights.length + 2];
        for (int i = 1; i < heights.length + 1; i++) new_heights[i] = heights[i - 1];
        //System.out.println(Arrays.toString(new_heights));
        for (int i = 0; i < new_heights.length; i++) {
            //System.out.println(stack.toString());
            while (!stack.isEmpty() && new_heights[stack.peek()] > new_heights[i]) {
                int cur = stack.pop();
                res = Math.max(res, (i - stack.peek() - 1) * new_heights[cur]);
            }
            stack.push(i);
        }
        return res;
    }//未完成



    public static void main(String[] args) {
        getMaxArea(new int[]{2,1,5,6,2,3});

    }
}


