package LimitJTextField;

import javax.print.attribute.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LimitJTextField extends PlainDocument {
    private int limit;

    public LimitJTextField(int limit) {
        super();
        this.limit = limit;
    }

    public void insertString( int offset, String  str, javax.swing.text.AttributeSet attr ) throws BadLocationException {
        if (str == null) return;

        if ( ( getLength() + str.length() ) <= limit ) {
            super.insertString(offset, str, attr);
        }
    }
}