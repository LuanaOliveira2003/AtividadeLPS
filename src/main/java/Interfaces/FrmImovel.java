/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;




import Classes.Imovel;
import dao.ImovelDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class FrmImovel extends javax.swing.JFrame {

    Imovel imEdit;
    ArrayList<Imovel> lista;
    private int id = 0;
    public int selectedId = 0;
    public int row = 0;
    
    public FrmImovel() throws ParseException, SQLException {
        this.imEdit = null;
        lista = new ArrayList<>();
        initComponents();
        carregarTabela();
        this.habilitarCampos(false);
        
        
    }

    public void habilitarCampos(boolean flag){
        
        edtId.setEnabled(false);
        edtCidade.setEnabled(flag);
        edtEstado.setEnabled(flag);
        edtCep.setEnabled(flag);
        edtRua.setEnabled(flag);
        edtBairro.setEnabled(flag);
        edtNumero.setEnabled(flag);
        edtReferencia.setEnabled(flag);
        edtValor.setEnabled(flag);
    }
    public void limparCampos(){
        
        edtId.setText("");
        edtCidade.setText("");
        edtEstado.setText("");
        edtCep.setText("");
        edtRua.setText("");
        edtBairro.setText("");
        edtNumero.setText("");
        edtReferencia.setText("");
        edtValor.setText("");
    }
    
    
   public void objetosParaCampos(JTable tableCategories, int row) {
        
        this.row = row;
        edtId.setText(tblImovel.getModel().getValueAt(row, 0).toString());
        edtCidade.setText(tblImovel.getModel().getValueAt(row, 1).toString());
        edtEstado.setText(tblImovel.getModel().getValueAt(row, 2).toString());
        edtCep.setText(tblImovel.getModel().getValueAt(row, 3).toString());
        edtRua.setText(tblImovel.getModel().getValueAt(row, 4).toString());
        edtBairro.setText(tblImovel.getModel().getValueAt(row, 5).toString());
        edtNumero.setText(tblImovel.getModel().getValueAt(row, 6).toString());
        edtReferencia.setText(tblImovel.getModel().getValueAt(row, 7).toString());
        edtValor.setText(tblImovel.getModel().getValueAt(row, 8).toString());
 
    }
    public void carregarTabela() throws SQLException{
          
         ImovelDAO a = new ImovelDAO();
         ResultSet data = a.index();
          
         DefaultTableModel model = (DefaultTableModel) this.tblImovel.getModel();
         
        while (data.next()) {
            System.out.println(data);
            model.addRow(new Object[]{data.getString("id_imovel"), data.getString("cidade"), data.getString("estado"), data.getString("cep"), data.getString("rua"), data.getString("bairro"), data.getString("numero"), data.getString("referencia"), data.getString("valor")});
        }
      }
    
    public void add(Imovel imovel) throws SQLException, ParseException {
        DefaultTableModel model = (DefaultTableModel) this.tblImovel.getModel();
        imovel.setId(0);
        int insertedId = ImovelDAO.getInstance().editar(imovel);
        model.addRow(new Object[]{insertedId,imovel.getCidade(), imovel.getEstado(), imovel.getCep(), imovel.getRua(), imovel.getBairro(), imovel.getNumero(), imovel.getReferencia(), imovel.getValor()});
    }
      
      public void edit(Imovel imovel) throws SQLException, ParseException {
        this.tblImovel.setValueAt(imovel.getCidade(), row, 1);
        this.tblImovel.setValueAt(imovel.getEstado(), row, 2);
        this.tblImovel.setValueAt(imovel.getCep(), row, 3);
        this.tblImovel.setValueAt(imovel.getRua(), row, 4);
        this.tblImovel.setValueAt(imovel.getBairro(), row, 5);
        this.tblImovel.setValueAt(imovel.getNumero(), row, 6);
        this.tblImovel.setValueAt(imovel.getReferencia(), row, 7);
        this.tblImovel.setValueAt(imovel.getValor(), row, 8);
        int aux = imovel.getId();
        aux++;
        imovel.setId(aux);
        System.out.println("auxiliar" + aux);
        ImovelDAO.getInstance().editar(imovel);
  
    }
      public void delete(int row) throws SQLException {
        Object[] options = {"Sim, remover", "Cancelar!"};
        int n = JOptionPane.showOptionDialog(this,
                "Tem certeza que deseja excluir o usuário?",
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        if (n == JOptionPane.YES_OPTION) {
            Imovel imovel = new Imovel();
            DefaultTableModel model = (DefaultTableModel) this.tblImovel.getModel();
            int x = Integer.parseInt((String) this.tblImovel.getValueAt(row, 0));
            ImovelDAO.getInstance().deletar(x);
            int[] rows = tblImovel.getSelectedRows();
            for (int i = 0; i < rows.length; i++) {
                model.removeRow(rows[i] - i);
            }
        }
      }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        pnlForm = new javax.swing.JPanel();
        edtId = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();
        edtCidade = new javax.swing.JTextField();
        lblCidade = new javax.swing.JLabel();
        edtCep = new javax.swing.JTextField();
        edtReferencia = new javax.swing.JTextField();
        lblReferencia = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        edtBairro = new javax.swing.JFormattedTextField();
        lblBairro = new javax.swing.JLabel();
        edtNumero = new javax.swing.JTextField();
        lblEstado = new javax.swing.JLabel();
        lblCep = new javax.swing.JLabel();
        edtRua = new javax.swing.JTextField();
        lblRua = new javax.swing.JLabel();
        edtEstado = new javax.swing.JTextField();
        lblValor = new javax.swing.JLabel();
        edtValor = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblImovel = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Gerenciamento de Imoveis");

        btnNovo.setText("Novo");
        btnNovo.setPreferredSize(new java.awt.Dimension(75, 30));
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.setMaximumSize(new java.awt.Dimension(75, 30));
        btnEditar.setMinimumSize(new java.awt.Dimension(75, 30));
        btnEditar.setPreferredSize(new java.awt.Dimension(75, 30));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.setPreferredSize(new java.awt.Dimension(75, 30));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.setPreferredSize(new java.awt.Dimension(75, 30));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.setPreferredSize(new java.awt.Dimension(75, 30));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setPreferredSize(new java.awt.Dimension(75, 30));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        pnlForm.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblId.setText("Id");

        lblCidade.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCidade.setText("Cidade");

        lblReferencia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblReferencia.setText("Referencia");

        lblNumero.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNumero.setText("Numero");

        lblBairro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblBairro.setText("Bairro");

        lblEstado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEstado.setText("Estado");

        lblCep.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCep.setText("CEP");

        lblRua.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblRua.setText("Rua");

        lblValor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblValor.setText("Valor");

        javax.swing.GroupLayout pnlFormLayout = new javax.swing.GroupLayout(pnlForm);
        pnlForm.setLayout(pnlFormLayout);
        pnlFormLayout.setHorizontalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormLayout.createSequentialGroup()
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFormLayout.createSequentialGroup()
                        .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBairro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNumero)
                            .addComponent(edtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 18, Short.MAX_VALUE)
                        .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblReferencia))
                        .addGap(61, 61, 61))
                    .addGroup(pnlFormLayout.createSequentialGroup()
                        .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edtId, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblId))
                        .addGap(18, 18, 18)
                        .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCidade)
                            .addComponent(edtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEstado)
                            .addComponent(edtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFormLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblRua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlFormLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(edtRua)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCep)
                    .addComponent(lblValor)
                    .addComponent(edtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        pnlFormLayout.setVerticalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormLayout.createSequentialGroup()
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(lblCidade)
                    .addComponent(lblEstado)
                    .addComponent(lblCep)
                    .addComponent(lblRua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumero)
                    .addComponent(lblBairro)
                    .addComponent(lblReferencia)
                    .addComponent(lblValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        tblImovel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "cidade", "estado", "cep", "rua", "bairro", "numero", "referencia", "valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblImovel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnlForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        this.limparCampos();
        this.habilitarCampos(true);
        selectedId =0;
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
       int row = this.tblImovel.getSelectedRow(); 
        if (row >= 0) {
            selectedId = 1;
            habilitarCampos(true);
            objetosParaCampos(this.tblImovel, row);
            
        } else {
            showMessageDialog(this, "Nenhum registro selecionado!");

        }
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (this.edtCidade.getText().isEmpty() || this.edtEstado.getText().isEmpty()|| this.edtCep.getText().isEmpty()|| this.edtRua.getText().isEmpty()|| this.edtBairro.getText().isEmpty()|| this.edtNumero.getText().isEmpty()|| this.edtReferencia.getText().isEmpty()|| this.edtValor.getText().isEmpty()) {
                    showMessageDialog(this, "Por favor, preencha todos os campos!");
                } else if (this.selectedId == 0) { //create
                    Imovel imovel = new Imovel(id++, this.edtCidade.getText(), this.edtEstado.getText(), this.edtCep.getText(), this.edtRua.getText(), this.edtBairro.getText(), Integer.parseInt(edtNumero.getText()), this.edtReferencia.getText(), Integer.parseInt(edtValor.getText()));
                    try {
                add(imovel);
                    } catch (SQLException ex) {
                        Logger.getLogger(FrmImovel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ParseException ex) {
                        Logger.getLogger(FrmImovel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    showMessageDialog(this, "Registro adicionado com sucesso!");
            this.limparCampos();
                } else { //update
                    Imovel imovel = new Imovel(this.selectedId, this.edtCidade.getText(), this.edtEstado.getText(), this.edtCep.getText(), this.edtRua.getText(), this.edtBairro.getText(), Integer.parseInt(edtNumero.getText()), this.edtReferencia.getText(), Integer.parseInt(edtValor.getText()));
                    try {
                        edit(imovel);
                    } catch (SQLException ex) {
                        Logger.getLogger(FrmImovel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ParseException ex) {
                        Logger.getLogger(FrmImovel.class.getName()).log(Level.SEVERE, null, ex);
                    }
     
                    
                    this.limparCampos();
                }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
       int row = tblImovel.getSelectedRow();
        if (row >= 0) {
            try {
                System.out.println(row);
               
                delete(row);
            } catch (SQLException ex) {
                Logger.getLogger(Imovel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            showMessageDialog(this, "Nenhum registro selecionado");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
     
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       this.limparCampos();
        this.habilitarCampos(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmCorretor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCorretor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCorretor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCorretor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JFormattedTextField edtBairro;
    private javax.swing.JTextField edtCep;
    private javax.swing.JTextField edtCidade;
    private javax.swing.JTextField edtEstado;
    private javax.swing.JTextField edtId;
    private javax.swing.JTextField edtNumero;
    private javax.swing.JTextField edtReferencia;
    private javax.swing.JTextField edtRua;
    private javax.swing.JTextField edtValor;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCep;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblReferencia;
    private javax.swing.JLabel lblRua;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValor;
    private javax.swing.JPanel pnlForm;
    private javax.swing.JTable tblImovel;
    // End of variables declaration//GEN-END:variables
}
