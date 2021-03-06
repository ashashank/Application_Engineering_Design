/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdminstrativeRole;

import Business.SalePerson;
import Business.SalePersonDirectory;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JPanel;

/**
 *
 * @author hpanjwani
 */
public class BestSalePersonPanel extends javax.swing.JPanel {
    
    private JPanel userProcessContainer;
    private SalePersonDirectory salePersonDirectory;
    ArrayList<SalePerson> salePersonList;
    
    SalePerson tempSalePerson;
    
    int minIndex = 0;

    /**
     * Creates new form BestSalePersonPanel
     */
    public BestSalePersonPanel(JPanel upc, SalePersonDirectory salePersonDirectory) {
        initComponents();
        userProcessContainer = upc;
        this.salePersonDirectory = salePersonDirectory;
        salePersonList = new ArrayList<>();
        
        topSalePerson();
    }
    
    public void topSalePerson() {
        
        for(SalePerson sp : salePersonDirectory.getSalePersonDirectory())   {
            salePersonList.add(sp);
        }
        
        //salePersonList.get(0).getSaleVolume()
        
        for(int i = 0; i < (salePersonList.size() - 1); i++)  {
            minIndex = i;
            
            for (int j = i + 1; j < salePersonList.size(); j++)              
                if(salePersonList.get(j).getSaleVolume() < salePersonList.get(minIndex).getSaleVolume())
                        minIndex = j;
                              
                if (minIndex != i) {
                    tempSalePerson = salePersonList.get(i);
                    salePersonList.set(i, salePersonList.get(minIndex));
                    salePersonList.set(minIndex, tempSalePerson);

                }        
        }
        
        int length = salePersonList.size();

        nameTextField.setText("1st SALES PERSON: " + salePersonList.get(length-1).getName());
        runnerUpTextField.setText("2nd SALES PERSON: " + salePersonList.get(length-2).getName());
        runnerTextField.setText("3rd SALES PERSON: " + salePersonList.get(length-3).getName());
        
        for(int r = 0; r < salePersonList.size(); r++)
            System.out.println(salePersonList.get(r));
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JLabel();
        runnerUpTextField = new javax.swing.JLabel();
        runnerTextField = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("TOP SALE PERSONS BY VOLUME");

        nameTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nameTextField.setText("jLabel2");

        runnerUpTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        runnerUpTextField.setText("jLabel3");

        runnerTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        runnerTextField.setText("jLabel4");

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("SALE PERSON NAME:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(runnerUpTextField)
                                    .addComponent(nameTextField)
                                    .addComponent(runnerTextField))
                                .addGap(66, 66, 66))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(nameTextField)
                .addGap(18, 18, 18)
                .addComponent(runnerUpTextField)
                .addGap(18, 18, 18)
                .addComponent(runnerTextField)
                .addGap(18, 18, 18)
                .addComponent(btnBack)
                .addContainerGap(49, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel nameTextField;
    private javax.swing.JLabel runnerTextField;
    private javax.swing.JLabel runnerUpTextField;
    // End of variables declaration//GEN-END:variables
}
