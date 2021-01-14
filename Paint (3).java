import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import javax.swing.JComponent;
import javax.swing.JFrame;


public class Paint extends JComponent {

    private Graphics2D g2d;
    private Image image;

    
    public static void main(String[] args) {
        new Paint();
    }

    public Paint() {
        initFrame();
    }

    private void initFrame() {
        JFrame frame = new JFrame("Midterm project");
        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        content.add(this, BorderLayout.CENTER);
        frame.setSize(850, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void drawBackground() {
        //SKY
        {
            g2d.setPaint(new Color(0x87CEEB));
            g2d.fillRect(0, 0, this.getSize().width, this.getSize().height);
        }
        //SUN
        {
            g2d.setPaint(new Color(0xFDD835));
            Shape sun = new Ellipse2D.Double(-75, -75, 150, 150);
            g2d.draw(sun);
            g2d.fill(sun);
            Path2D sunRay = new Path2D.Float();
            sunRay.moveTo(0, 0);
            sunRay.lineTo(200, 20);
            sunRay.lineTo(200, -20);
            sunRay.closePath();
            int numRays = 15;
            for (int i = 0; i < numRays; i++) {
                g2d.fill(sunRay);
                g2d.rotate((Math.PI * 2) / numRays);
            }
        }
        //GROUND
        {
            g2d.setColor(new Color(0x7EC850));
            g2d.fillRect(0, 400, this.getSize().width, this.getSize().height);
        }
        //CLOUD
        {
            g2d.setColor(new Color(0xD8DDDF));
            Shape cloudLeft[] = new Shape[3];
            Shape cloudRight[] = new Shape[3];
            Shape cloudCenter[] = new Shape[3];

            cloudLeft[0] = new Ellipse2D.Double(300, 100, 40, 40);
            cloudCenter[0] = new Ellipse2D.Double(320, 90, 50, 50);
            cloudRight[0] = new Ellipse2D.Double(350, 100, 35, 35);

            cloudLeft[1] = new Ellipse2D.Double(480, 60, 40, 40);
            cloudCenter[1] = new Ellipse2D.Double(500, 50, 50, 50);
            cloudRight[1] = new Ellipse2D.Double(530, 60, 35, 35);

            cloudLeft[2] = new Ellipse2D.Double(650, 120, 40, 40);
            cloudCenter[2] = new Ellipse2D.Double(670, 110, 50, 50);
            cloudRight[2] = new Ellipse2D.Double(700, 120, 35, 35);

            for (int i = 0; i < 3; i++) {
                g2d.draw(cloudLeft[i]);
                g2d.fill(cloudLeft[i]);
                g2d.draw(cloudCenter[i]);
                g2d.fill(cloudCenter[i]);
                g2d.draw(cloudRight[i]);
                g2d.fill(cloudRight[i]);
            }
        }
        //TREE
        {
            g2d.setColor(new Color(0x53350A));
            Shape treeTrunk = new Rectangle(200, 320, 50, 150);
            g2d.draw(treeTrunk);
            g2d.fill(treeTrunk);
            g2d.setColor(new Color(0x3A5F0B));
            int numLeaves = 3;
            int leafRadius = 60;
            int leavesRadius = 30;
            Point leavesCenter = new Point(195, 245);
            for (int i = 0; i < numLeaves + 3; i++) {
                double leafX = leavesCenter.getX() + leavesRadius * Math.cos((Math.PI * i) / numLeaves);
                double leafY = leavesCenter.getY() + leavesRadius * Math.sin((Math.PI * i) / numLeaves);
                Shape leaf = new Ellipse2D.Double(leafX, leafY, leafRadius, leafRadius);
                g2d.draw(leaf);
                g2d.fill(leaf);
            }
            g2d.setColor(new Color(0xff0800));
            int appleRadius = 20;
            int applesRadius = 35;
            for (int i = 0; i < numLeaves; i++) {
                double appleX = leavesCenter.getX() + 20 + applesRadius * Math.cos((Math.PI * i) / numLeaves);
                double appleY = leavesCenter.getY() + 20 + applesRadius * Math.sin((Math.PI * i) / numLeaves);
                Shape apple = new Ellipse2D.Double(appleX, appleY, appleRadius, appleRadius);
                g2d.draw(apple);
                g2d.fill(apple);
            }
            g2d.setColor(new Color(0x53350A));
            Shape treeTrunk2 = new Rectangle(700, 300, 50, 125);
            g2d.draw(treeTrunk2);
            g2d.fill(treeTrunk2);
            g2d.setColor(new Color(0x3A5F0B));
            leavesCenter = new Point(695, 255);
            for (int i = 0; i < numLeaves + 5; i++) {
                double leafX = leavesCenter.getX() + leavesRadius * Math.cos((Math.PI * i) / numLeaves);
                double leafY = leavesCenter.getY() + leavesRadius * Math.sin((Math.PI * i) / numLeaves);
                Shape leaf = new Ellipse2D.Double(leafX, leafY, leafRadius, leafRadius);
                g2d.draw(leaf);
                g2d.fill(leaf);
            }
            g2d.setColor(new Color(0xff0800));
            for (int i = 0; i < numLeaves + 2; i++) {
                double appleX = leavesCenter.getX() + 20 + applesRadius * Math.cos((Math.PI * i) / (numLeaves + 1));
                double appleY = leavesCenter.getY() + 20 + applesRadius * Math.sin((Math.PI * i) / (numLeaves - 1));
                Shape apple = new Ellipse2D.Double(appleX, appleY, appleRadius, appleRadius);
                g2d.draw(apple);
                g2d.fill(apple);
            }
        }
        //HOUSE
        {
            g2d.setColor(new Color(0x0FFFDD0));
            Polygon poly = new Polygon();
            poly.addPoint(400, 300);
            poly.addPoint(500, 300);
            poly.addPoint(450, 350);
            poly.addPoint(350, 350);
            g2d.fillPolygon(poly);
            g2d.setColor(new Color(0x7C0A02));
            poly = new Polygon();
            poly.addPoint(350, 350);
            poly.addPoint(450, 350);
            poly.addPoint(450, 430);
            poly.addPoint(350, 430);
            g2d.fillPolygon(poly);
            g2d.setColor(new Color(0x7C0A02));
            poly = new Polygon();
            poly.addPoint(450, 430);
            poly.addPoint(450, 350);
            poly.addPoint(500, 300);
            poly.addPoint(540, 340);
            poly.addPoint(540, 420);
            g2d.fillPolygon(poly);
            g2d.setColor(new Color(0xD3D3D3));
            poly = new Polygon();
            poly.addPoint(447, 430);
            poly.addPoint(447, 350);
            poly.addPoint(450, 350);
            poly.addPoint(450, 430);
            g2d.fillPolygon(poly);
            poly = new Polygon();
            poly.addPoint(350, 430);
            poly.addPoint(350, 350);
            poly.addPoint(353, 350);
            poly.addPoint(353, 430);
            g2d.fillPolygon(poly);
            poly = new Polygon();
            poly.addPoint(450, 350);
            poly.addPoint(540, 340);
            poly.addPoint(540, 343);
            poly.addPoint(450, 353);
            g2d.fillPolygon(poly);
            poly = new Polygon();
            poly.addPoint(540, 340);
            poly.addPoint(540, 420);
            poly.addPoint(537, 420);
            poly.addPoint(537, 340);
            g2d.fillPolygon(poly);
            poly = new Polygon();
            poly.addPoint(540, 420);
            poly.addPoint(450, 430);
            poly.addPoint(450, 427);
            poly.addPoint(540, 417);
            g2d.fillPolygon(poly);
            poly = new Polygon();
            poly.addPoint(350, 430);
            poly.addPoint(450, 430);
            poly.addPoint(450, 427);
            poly.addPoint(350, 427);
            g2d.fillPolygon(poly);
            poly = new Polygon();
            poly.addPoint(350, 350);
            poly.addPoint(450, 350);
            poly.addPoint(450, 353);
            poly.addPoint(350, 353);
            g2d.fillPolygon(poly);
            poly = new Polygon();
            poly.addPoint(450, 350);
            poly.addPoint(500, 300);
            poly.addPoint(500, 303);
            poly.addPoint(450, 353);
            g2d.fillPolygon(poly);
            poly = new Polygon();
            poly.addPoint(500, 300);
            poly.addPoint(540, 340);
            poly.addPoint(537, 340);
            poly.addPoint(497, 300);
            g2d.fillPolygon(poly);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        System.out.println("im here");
        if (image == null) {
            System.out.println("im here 2");
            image = createImage(getSize().width, getSize().height);
            g2d = (Graphics2D) image.getGraphics();
            drawBackground();
        }
        g.drawImage(image, 0, 0, null);
    }

}
