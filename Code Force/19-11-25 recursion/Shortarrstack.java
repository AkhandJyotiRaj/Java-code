class Solution {
    
    // Main function to sort the stack
    public void sortStack(Stack<Integer> st) {
        if (!st.isEmpty()) {
            int top = st.pop();
            sortStack(st);
            insertSorted(st, top);
        }
    }

    // Helper function to insert an element in sorted order
    private void insertSorted(Stack<Integer> st, int value) {
        // If stack is empty or top element is <= value, push it
        if (st.isEmpty() || st.peek() <= value) {
            st.push(value);
            return;
        }

        int top = st.pop();
        insertSorted(st, value);
        st.push(top);
    }
}
