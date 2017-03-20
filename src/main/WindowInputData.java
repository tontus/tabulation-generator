package main;


import customSwing.CButton;
import customSwing.CFrame;
import customSwing.CPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kazi Mainul Islam on 3/17/2017.
 */
public class WindowInputData{

    CFrame frame;
    CPanel panel, panelChoose, panelBtn;

    JLabel lblCourseCode, lblCredit, lblLab;

    JTextField tfCourseCode, tfCredit;

    JButton btnChooseFile;
    JCheckBox box;

    CButton btnGenerate;
    CButton btnNext;

    static String location;

    static String[] attribute = new String[20];
    public static double[] credit = new double[20];

    private static int counterBtn = 0;


    WindowInputData(){
        GridBagConstraints c = new GridBagConstraints();
        GridBagConstraints cb = new GridBagConstraints();

        Insets insest = new Insets(5,5,5,5);

        panelChoose = new CPanel(new GridBagLayout());



        lblCourseCode = new JLabel("Course Code");
        lblCredit = new JLabel("Credit");
        lblLab = new JLabel("Lab");

        tfCourseCode = new JTextField(10);
        tfCredit = new JTextField(10);
        box = new JCheckBox();

        btnNext = new CButton("Next");
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                boolean isLab = box.isSelected();
                if(!isLab){
                    try{
                        String cCode = tfCourseCode.getText();
                        attribute[StoreResult.positionCounter] = cCode;
                        credit[StoreResult.positionCounter] = Double.parseDouble(tfCredit.getText());
                        FileProcessing.process(location);
                        JLabel lblAdd = new JLabel( cCode + " Course Added");
                        c.gridy++;
                        panelChoose.add(lblAdd, c);
                        tfCourseCode.setText("");
                        tfCredit.setText("");
                        frame.revalidate();
                        frame.repaint();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                else {
                    try{
                        String cCode = tfCourseCode.getText();
                        attribute[StoreResult.positionCounter] = cCode;
                        credit[StoreResult.positionCounter] = Double.parseDouble(tfCredit.getText());
                        FileProcessing.processLab(location);
                        JLabel lblAdd = new JLabel( cCode + " Course Added");
                        c.gridy++;
                        panelChoose.add(lblAdd, c);
                        box.setSelected(false);
                        tfCourseCode.setText("");
                        tfCredit.setText("");
                        frame.revalidate();
                        frame.repaint();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

            }
        });

        btnChooseFile = new JButton("choose");
        btnChooseFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                try {
                    FileChooser file = new FileChooser();
                    location = file.getFileLocation();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

        btnGenerate = new CButton("Generate");
        btnGenerate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (int i =0; i<StoreResult.positionCounter; i++)
                    System.out.println("##################Credit"+credit[i]);
                PDFCreator.createTable(StoreResult.positionCounter+3);
                PDFCreator.addAttribure(attribute, StoreResult.positionCounter);
                PDFCreator.addValue("Credit Completed");
                PDFCreator.addValue("CGPA");
                StoreResult.addInfoToTable();
                PDFCreator.createPdf();
                System.out.println("Done");
            }
        });


        panelBtn = new CPanel(new GridBagLayout());
        cb.gridx = 0;
        cb.gridy = 0;
        cb.insets = insest;
        panelBtn.add(btnNext,cb);
        cb.gridy++;
        panelBtn.add(btnGenerate, cb);

        ////upper Panel
        c.gridx = 0;
        c.gridy = 20;
        c.insets = insest;
        panelChoose.add(lblCourseCode,c);
        c.gridx++;
        panelChoose.add(lblCredit,c);
        c.gridx++;
        panelChoose.add(lblLab,c);
        c.gridy = 21;
        c.gridx = 0;
        panelChoose.add(tfCourseCode,c);
        c.gridx++;
        panelChoose.add(tfCredit,c);
        c.gridx++;
        panelChoose.add(box, c);
        c.gridx++;
        panelChoose.add(btnChooseFile, c);
        c.gridx = 1;
        c.gridy = 0;


        //main Panel
        GridBagConstraints cMain = new GridBagConstraints();
        panel = new CPanel(new GridBagLayout());
        cMain.gridx = 0;
        cMain.gridy = 0;
        panel.add(panelChoose, cMain);
        cMain.gridy++;
        panel.add(panelBtn, cMain);

        GridBagConstraints cf = new GridBagConstraints();
        frame = new CFrame("Tabulation Sheet Generator");
        frame.add(panel);

    }



}
