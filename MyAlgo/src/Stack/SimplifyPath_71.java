package Stack;

import java.util.Objects;
import java.util.Stack;

public class SimplifyPath_71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");

        for (String dir : components) {
            if (Objects.equals(dir, "..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!dir.equals(".") && !dir.isEmpty()) {
                stack.push(dir);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }

        return result.length() > 0 ? result.toString() : "/";
    }
    public static void main(String[] args) {
        SimplifyPath_71 sp = new SimplifyPath_71();
        String path = "/asb/../d/";
        System.out.println("Simplified path: " + sp.simplifyPath(path));
    }
}
