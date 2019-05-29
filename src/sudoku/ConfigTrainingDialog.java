/*
 * Copyright (C) 2008-12  Bernhard Hobiger
 *
 * This file is part of HoDoKu.
 *
 * HoDoKu is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * HoDoKu is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with HoDoKu. If not, see <http://www.gnu.org/licenses/>.
 */

package sudoku;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

/**
 *
 * @author  hobiwan
 */
public class ConfigTrainingDialog extends javax.swing.JDialog {
    private static final long serialVersionUID = 1L;
    private ConfigTrainigPanel myConfigTrainingPanel;
    private boolean okPressed;

    /** Creates new form ConfigDialog
     * @param parent
     * @param modal  
     */
    public ConfigTrainingDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        okPressed = false;
        
        getRootPane().setDefaultButton(okButton);

        KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action escapeAction = new AbstractAction() {
            private static final long serialVersionUID = 1L;
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible( false );
            }
        };
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
        
        myConfigTrainingPanel = new ConfigTrainigPanel();
        containerPanel.add(myConfigTrainingPanel, BorderLayout.CENTER);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        containerPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("intl/ConfigTrainingDialog"); // NOI18N
        setTitle(bundle.getString("ConfigTrainingDialog.title")); // NOI18N

        okButton.setMnemonic(java.util.ResourceBundle.getBundle("intl/ConfigTrainingDialog").getString("ConfigTrainingDialog.okButton.mnemonic").charAt(0));
        okButton.setText(bundle.getString("ConfigTrainingDialog.okButton.text")); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setMnemonic(java.util.ResourceBundle.getBundle("intl/ConfigTrainingDialog").getString("ConfigTrainingDialog.cancelButton.mnemonic").charAt(0));
        cancelButton.setText(bundle.getString("ConfigTrainingDialog.cancelButton.text")); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        containerPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        containerPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(okButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton))
                    .addComponent(containerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, okButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(containerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        myConfigTrainingPanel.okPressed();
        try {
            Options.getInstance().writeOptions();
        } catch (FileNotFoundException ex) {
            MessageFormat formatter = new MessageFormat(java.util.ResourceBundle.getBundle("intl/MainFrame").getString("MainFrame.invalid_filename"));
            String msg = formatter.format(new Object[] { ex.getLocalizedMessage() });
            JOptionPane.showMessageDialog(this, msg, 
                    java.util.ResourceBundle.getBundle("intl/ConfigDialog").getString("ConfigDialog.error"), JOptionPane.ERROR_MESSAGE);
        }
        okPressed = true;
        setVisible(false);
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        //System.out.println("Cancel pressed...");
        okPressed = false;
        setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {}
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ConfigTrainingDialog(new javax.swing.JFrame(), true).setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel containerPanel;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the okPressed
     */
    public boolean isOkPressed() {
        return okPressed;
    }
    
}
