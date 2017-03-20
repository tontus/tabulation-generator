package main;

import javax.swing.*;

/**
 * Created by Kazi Mainul Islam on 3/15/2017.
 */
public class FileChooser {


    private String fileLocation;

    FileChooser(){
        JFileChooser browse = new JFileChooser();
        browse.setCurrentDirectory(new java.io.File("."));
        browse.setDialogTitle("Browse");
        browse.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if(browse.showOpenDialog(new JButton()) == JFileChooser.APPROVE_OPTION){

        }
        fileLocation = (String)browse.getSelectedFile().getAbsolutePath();
    }


    public String getFileLocation() {
        return fileLocation;
    }
}
