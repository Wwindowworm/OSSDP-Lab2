/**
 * @description:
 *
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 *
 * 示例 1：
 *
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 *
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 *
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 */
class Solution2 {
    public String removeDuplicateLetters(String s) {
        boolean[] vis = new boolean[26]; // 修改数组大小为26，因为'a'-'z'共26个字母
        int[] num = new int[26]; // 同上

        // 初始化计数数组
        for (int i = 0; i < 26; i++) {
            num[i] = 0;
        }

        // 统计字符出现次数
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++; // 应该减去'a'而不是' '
        }

        StringBuilder sb = new StringBuilder(); // 使用StringBuilder替代StringBuffer，非线程安全但性能更好
        for (int i = 0; i < s.length(); i++) { // 循环条件应为s.length()
            char ch = s.charAt(i);
            if (!vis[ch - 'a']) { // 检查是否已访问
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch && num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                    vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                    sb.deleteCharAt(sb.length() - 1);
                }
                vis[ch - 'a'] = true;
                sb.append(ch);
            }
            num[ch - 'a']--; // 这里应该减少次数，因为当前字符已经被处理了
        }
        return sb.toString();
    }
}

