package academia;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import javax.swing.border.Border;

public class PintaImagen implements Border{

	private BufferedImage image ;
        boolean verificar;

	public PintaImagen(BufferedImage image) {
                verificar=true;
		this.image=image;
        }
        public PintaImagen(){
            verificar=false;
        }
    @Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            if(verificar){
                int x0 = x+(width-image.getWidth())/2;
                int y0 = y+(height-image.getHeight())/2;
                g.drawImage(image, x, y, width, height, c);
            }
            else{
                g.drawImage(null, 0, 0, c);
            }
        }

    @Override
    public Insets getBorderInsets(Component c) {
	return new Insets(0,0,0,0);}

    @Override
    public boolean isBorderOpaque() {
	return true; }
}