
package br.com.hitalo.interfaces;

import br.com.hitalo.connect.DBManager;
import br.com.hitalo.forms.Produto;
import java.sql.SQLException;
import javax.swing.JFrame;


public class PainelNovoProduto extends javax.swing.JPanel {

    private JFrame parent;
    private Produto produto;
    
    public PainelNovoProduto(JFrame parent) {
        initComponents();
        this.parent = parent;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfNomeProduto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfUnidade = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfMarca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btAdicionarProduto = new javax.swing.JButton();
        tfValor = new javax.swing.JFormattedTextField();
        lbMensagem = new javax.swing.JLabel();

        jLabel1.setText("Nome");

        jLabel2.setText("Marca");

        jLabel3.setText("Unidade");

        tfMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMarcaActionPerformed(evt);
            }
        });

        jLabel4.setText("Valor");

        btAdicionarProduto.setText("Adicionar Produto");
        btAdicionarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarProdutoActionPerformed(evt);
            }
        });

        tfValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        tfValor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        lbMensagem.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btAdicionarProduto)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4))
                            .addGap(65, 65, 65)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfUnidade, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                                .addComponent(tfNomeProduto)
                                .addComponent(tfMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                                .addComponent(tfValor)
                                .addComponent(lbMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(tfUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btAdicionarProduto)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tfMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfMarcaActionPerformed

    private void btAdicionarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarProdutoActionPerformed

             produto = new Produto(tfNomeProduto.getText().trim(), tfMarca.getText().trim(), tfUnidade.getText().trim(), 0);

            if(isProdutoValido()) {
                 try {
                     new DBManager().addProduto(produto);
                     tfNomeProduto.setText("");
                     tfMarca.setText("");
                     tfUnidade.setText("");
                     tfValor.setText("");
                     lbMensagem.setText("Produto adicionado");
                 } catch (SQLException ex) {
                     System.err.println(ex.getMessage());
                     ex.printStackTrace();
                 }
            }
        
    }//GEN-LAST:event_btAdicionarProdutoActionPerformed

    
    private boolean isProdutoValido() {
        
        if(produto.getNome().isEmpty()) {
            lbMensagem.setText("Campo nome do produto não pode estar vazio");
            return false;
        } else if(produto.getMarca().isEmpty()) {
            lbMensagem.setText("Campo marca do produto não pode estar vazio");
            return false;
        } else if(produto.getUnidade().isEmpty()) {
            lbMensagem.setText("Campo unidade do produto não pode estar vazio");
            return false;
        } else if(tfValor.getText().trim().isEmpty()) {
            lbMensagem.setText("Campo valor do produto não pode estar vazio");
            return false;
        } 
        
        try {
            produto.setValor(Float.valueOf(tfValor.getText().trim().replace(",", ".")));
        } catch(NumberFormatException ex) {
            lbMensagem.setText("Valor do produto inválidooooooo");
            return false;
        }
        
        if(produto.getValor() <= 0) {
            lbMensagem.setText("Valor do produto inválido");
            return false;
        } 
        
        return true;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionarProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbMensagem;
    private javax.swing.JTextField tfMarca;
    private javax.swing.JTextField tfNomeProduto;
    private javax.swing.JTextField tfUnidade;
    private javax.swing.JFormattedTextField tfValor;
    // End of variables declaration//GEN-END:variables
}
