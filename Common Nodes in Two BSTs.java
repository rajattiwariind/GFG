class Solution {
    public ArrayList<Integer> findCommon(Node r1, Node r2) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
                Stack<Node> s1 = new Stack<>();
                Stack<Node> s2 = new Stack<>();

                while (true) {
                    while (r1 != null) {
                        s1.push(r1);
                        r1 = r1.left;
                    }
                    while (r2 != null) {
                        s2.push(r2);
                        r2 = r2.left;
                    }

                    if (s1.isEmpty() || s2.isEmpty()) {
                        break;
                    }

                    Node t1 = s1.peek();
                    Node t2 = s2.peek();

                    if (t1.data == t2.data) {
                        res.add(t1.data);
                        s1.pop();
                        s2.pop();
                        r1 = t1.right;
                        r2 = t2.right;
                    } else if (t1.data < t2.data) {
                        s1.pop();
                        r1 = t1.right;
                    } else {
                        s2.pop();
                        r2 = t2.right;
                    }
                }

                return res;
    }
}
