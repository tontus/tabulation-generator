package customSwing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Kazi Mainul Islam on 3/15/2017.
 */
public class CComboBox extends JComboBox {

    Dimension d = new Dimension(125, 30);

    CComboBox(Object[] arr){

        super(arr);
        super.setPreferredSize(d);
    }
}
