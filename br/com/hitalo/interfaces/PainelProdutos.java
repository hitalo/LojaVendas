
package br.com.hitalo.interfaces;

import br.com.hitalo.connect.DBManager;
import br.com.hitalo.dialogs.NovoEditarProduto;
import br.com.hitalo.forms.Produto;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class PainelProdutos extends javax.swing.JPanel {

    private JFrame parent;
    private DBManager dbManager;
    private TableRowSorter<TableModel> rowSorter;
    
    public PainelProdutos(JFrame parent) {
        initComponents();
        this.parent = parent;
        dbManager = new DBManager();
        setSorter();
        preencherTabelaProdutosBuscados();
    }

    
    private void preencherTabelaProdutosBuscados() {
        DefaultTableModel model = (DefaultTableModel) tbProdutosBuscados.getModel();
        
        model.setRowCount(0);
        try {
            Iterator<Produto> itProdutos = dbManager.getProdutos().iterator();
            
            Produto produto;
            while(itProdutos.hasNext()) {
                produto = itProdutos.next();
                model.addRow(new Object[]{produto.getId(), produto.getNome(), produto.getMarca(), produto.getUnidade(), produto.getValor()});
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        
    }
    
    private void setSorter() {
        rowSorter = new TableRowSorter<>(tbProdutosBuscados.getModel());
        tbProdutosBuscados.setRowSorter(rowSorter);
        
        tfBuscar.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = tfBuscar.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = tfBuscar.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbProdutosBuscados = new javax.swing.JTable();
        tfBuscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btNovoProduto = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        lbMensagem = new javax.swing.JLabel();

        tbProdutosBuscados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Marca", "Unidade", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbProdutosBuscados);

        jLabel2.setText("Produtos");

        btNovoProduto.setText("Novo");
        btNovoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoProdutoActionPerformed(evt);
            }
        });

        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        lbMensagem.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btNovoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfBuscar, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE))
                        .addGap(64, 64, 64))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(lbMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovoProduto)
                    .addComponent(btEditar)
                    .addComponent(btExcluir))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btNovoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoProdutoActionPerformed
        NovoEditarProduto novoProduto = new NovoEditarProduto(parent, true);
        novoProduto.showDialog();
        preencherTabelaProdutosBuscados();
    }//GEN-LAST:event_btNovoProdutoActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        
        if(tbProdutosBuscados.getSelectedRowCount() == 1) {
            lbMensagem.setText("");
            if(JOptionPane.showConfirmDialog(parent, "Excluir produto selecionado?") == JOptionPane.OK_OPTION) {
                try {
                    new DBManager().excluirProduto(
                            tbProdutosBuscados.getModel().getValueAt(
                                tbProdutosBuscados.convertRowIndexToModel(tbProdutosBuscados.getSelectedRow()), 0).toString());
                    preencherTabelaProdutosBuscados();
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                    ex.printStackTrace();
                }
            }
        } else {
            lbMensagem.setText("Nenhum produto selecionado!");
        }
        
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        if(tbProdutosBuscados.getSelectedRowCount() == 1) {
            lbMensagem.setText("");
            
            DefaultTableModel modelProdutosBuscados = (DefaultTableModel) tbProdutosBuscados.getModel();
            
            Produto produto = new Produto();
            produto.setId(modelProdutosBuscados.getValueAt(tbProdutosBuscados.convertRowIndexToModel(tbProdutosBuscados.getSelectedRow()), 0).toString());
            produto.setNome(modelProdutosBuscados.getValueAt(tbProdutosBuscados.convertRowIndexToModel(tbProdutosBuscados.getSelectedRow()), 1).toString());
            produto.setMarca(modelProdutosBuscados.getValueAt(tbProdutosBuscados.convertRowIndexToModel(tbProdutosBuscados.getSelectedRow()), 2).toString());
            produto.setUnidade(modelProdutosBuscados.getValueAt(tbProdutosBuscados.convertRowIndexToModel(tbProdutosBuscados.getSelectedRow()), 3).toString());
            produto.setValor(Float.valueOf(modelProdutosBuscados.getValueAt(tbProdutosBuscados.convertRowIndexToModel(tbProdutosBuscados.getSelectedRow()), 4).toString()));
            
            NovoEditarProduto editarProduto = new NovoEditarProduto(parent, true);
            editarProduto.setValues(produto);
            editarProduto.showDialog();
            preencherTabelaProdutosBuscados();
            
        } else {
            lbMensagem.setText("Nenhum produto selecionado!");
        }
    }//GEN-LAST:event_btEditarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovoProduto;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbMensagem;
    private javax.swing.JTable tbProdutosBuscados;
    private javax.swing.JTextField tfBuscar;
    // End of variables declaration//GEN-END:variables
}
