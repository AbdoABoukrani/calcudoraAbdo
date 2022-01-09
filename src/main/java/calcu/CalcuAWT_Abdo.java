
package calcu;

import java.awt.*;
import java.awt.event.*;


public class CalcuAWT_Abdo extends Frame implements ActionListener {
    
public static void main (String args[]) {
		CalcuAWT_Abdo c = new CalcuAWT_Abdo("CalcuAWT_Abdo",400,400);
	}

	public String botones[] = {"1","2","3","+","4","5","6","-","7","8","9","*","0","/","=","AC"};
	 int resultado = 0;
	public TextField calculo;

	public int cifras[] = new int[20];
	public int[] calculos = new int[20];
	public int c; 

	public CalcuAWT_Abdo (String nombreVentana, int anchura, int altura) {
		
		setLayout(new GridLayout(2,1));
                setTitle(nombreVentana);
		setSize(anchura,altura);
		calculo = new TextField("");
		add(calculo);

		cifras[0] = 0;
		calculos[0] = 0;
		c = 1;

		Panel panelBotones = new Panel(new GridLayout(4,4));
		for (int i=0;i<botones.length;i++) {
			Button botoncito = new Button(botones[i]);
			botoncito.addActionListener(this);
			panelBotones.add(botoncito);
		}
		add(panelBotones);

                show();
                
                 addWindowListener(new WindowListener() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowOpened(WindowEvent we) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowClosed(WindowEvent we) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowIconified(WindowEvent we) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowDeiconified(WindowEvent we) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowActivated(WindowEvent we) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowDeactivated(WindowEvent we) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
	}

	

	public void opera (String op) {
		if (ordenNumerica(op)) {
			if (((String)calculo.getText()).equals("0")) calculo.setText(op);
			else calculo.setText(calculo.getText()+op);
		} else if (op.equals("+")) {
			cifras[c] = Integer.parseInt(calculo.getText());
			calculos[c] = 0;
			c+=1;
			calculo.setText("");
		} else if (op.equals("-")) {
			cifras[c] = Integer.parseInt(calculo.getText());
			calculos[c] = 1;
			c+=1;
			calculo.setText("");
		} else if (op.equals("*")) {
			cifras[c] = Integer.parseInt(calculo.getText());
			calculos[c] = 2;
			c+=1;
			calculo.setText("");
		} else if (op.equals("/")) {
			cifras[c] = Integer.parseInt(calculo.getText());
			calculos[c] = 3;
			c+=1;
			calculo.setText("");
		} else if (op.equals("=")) {
			cifras[c] = Integer.parseInt(calculo.getText());
			calculo.setText(String.valueOf(igual()));
			c = 0;
			cifras[0] = Integer.parseInt(calculo.getText());
		} else if (op.equals("Borrar")) {
			cifras[0] = 0;
			c = 0;
			calculo.setText("");
		}
	}

	

	public int igual () {
		int resultado = cifras[0];
		for (int x=1;x<=c;x++) {
			if (calculos[x-1]==0) resultado += cifras[x];
			else if (calculos[x-1]==1) resultado -= cifras[x];
			else if (calculos[x-1]==2) resultado *= cifras[x];
			else if (calculos[x-1]==3) resultado /= cifras[x];
		}
		return resultado;
	}

	public void actionPerformed (ActionEvent e) {
		String operacion = ((Button)e.getSource()).getLabel();
		opera(operacion);
	}
        public boolean ordenNumerica (String orden) {
		try {
			Integer.parseInt(orden);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

}