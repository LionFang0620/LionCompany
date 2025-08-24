package util;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class InputUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**監聽欄位輸入，若有任一欄位有輸入內容才啟用按鈕**/
	public static void enableButtonWhenAnyFieldNotEmpty(JTextField[] fields, JButton button) {
        DocumentListener listener = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { check(); }
            public void removeUpdate(DocumentEvent e) { check(); }
            public void changedUpdate(DocumentEvent e) {}

            private void check() {
                for (JTextField field : fields) {
                    if (!field.getText().trim().isEmpty()) {
                        button.setEnabled(true);
                        return;
                    }
                }
                button.setEnabled(false);
            }
        };

        for (JTextField field : fields) {
            field.getDocument().addDocumentListener(listener);
        }
    }
	/**監聽JTextField輸入數量，大於零才啟動按鈕**/
	public static void enableButtonWhenAnyQuantityGreaterThanZero(JTextField[] fields, JButton button) {
	    DocumentListener listener = new DocumentListener() {
	        public void insertUpdate(DocumentEvent e) { check(); }
	        public void removeUpdate(DocumentEvent e) { check(); }
	        public void changedUpdate(DocumentEvent e) {}

	        private void check() {
	            for (JTextField field : fields) {
	                String text = field.getText().trim();
	                if (!text.isEmpty()) {
	                    try {
	                        int value = Integer.parseInt(text);
	                        if (value > 0) {
	                            button.setEnabled(true);
	                            return;
	                        }
	                    } catch (NumberFormatException ex) {
	                        // 忽略非數字輸入
	                    }
	                }
	            }
	            button.setEnabled(false);
	        }
	    };

	    for (JTextField field : fields) {
	        field.getDocument().addDocumentListener(listener);
	    }
	}
	/**監聽JTextArea是否有內容，有內容才啟動按鈕**/
	public static void enableButtonWhenTextAreaNotEmpty(JTextArea textArea, JButton button) {
	    DocumentListener listener = new DocumentListener() {
	        public void insertUpdate(DocumentEvent e) { check(); }
	        public void removeUpdate(DocumentEvent e) { check(); }
	        public void changedUpdate(DocumentEvent e) {}

	        private void check() {
	            if (!textArea.getText().trim().isEmpty()) {
	                button.setEnabled(true);
	            } else {
	                button.setEnabled(false);
	            }
	        }
	    };

	    textArea.getDocument().addDocumentListener(listener);
	}
	
}
