package presentacion;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelRound extends JLabel {
  private String nombre;
  
  private ImageIcon icono;
  
  private final BorderRound border;
  
  public JLabelRound() {
    this.nombre = "";
    this.icono = null;
    this.border = new BorderRound();
    this.nombre = "";
    initComponent();
  }
  
  public JLabelRound(String info) {
    this.nombre = "";
    this.icono = null;
    this.border = new BorderRound();
    this.nombre = info;
    initComponent();
  }
  
  public JLabelRound(ImageIcon info) {
    this.nombre = "";
    this.icono = null;
    this.border = new BorderRound();
    this.icono = info;
    initComponent();
  }
  
  private void initComponent() {
    setText(this.nombre);
    setHorizontalAlignment(0);
    setIcon(this.icono);
    setOpaque(true);
    setBorder(this.border);
    setPreferredSize(new Dimension(100, 100));
  }
}