import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel() {
        // Konstruktor kosong untuk GUI Builder
    }

    public void setBackgroundImage(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            // Gambar background memenuhi seluruh panel sesuai ukuran frame saat ini
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}