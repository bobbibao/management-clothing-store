package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class GD_CommonLayout extends JFrame {
	private static final long serialVersionUID = 1L;
	private final int WIDTH = 1400;
	private final int HEIGHT = 1000;
	public GD_CommonLayout(String title) {
		//setup screan
		super("CỬA HÀNG BÁN QUẦN ÁO THỜI TRANG BOBBI");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
//		setResizable(false);
		
		//create layout
		JPanel container = new JPanel(new BorderLayout());
		JPanel navigation = navigationUI(title);
		JPanel sideBar = sideBarUI();
		JPanel content = contentUI();
		
		content.add(navigation, BorderLayout.NORTH);
		container.add(sideBar, BorderLayout.WEST);
		container.add(content, BorderLayout.CENTER);
		
		Color backgroundColorContainer = Color.decode("#F5EFE0");
		container.setBackground(backgroundColorContainer);
		
		container.add(sideBar, BorderLayout.WEST);
		this.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {

				switch (e.getKeyCode()) {
					case KeyEvent.VK_F1:
						System.out.println("Ban Hang");
						break;
					case KeyEvent.VK_F2:
						System.out.println("khach Hang");
						break;
					case KeyEvent.VK_F3:
						System.out.println("NhanVien");
						break;
					case KeyEvent.VK_F4:
						System.out.println("QuanAo");
						break;
					case KeyEvent.VK_F5:
						System.out.println("NCC");
						break;
					case KeyEvent.VK_F6:
						System.out.println("Thong ke");
						break;
					case KeyEvent.VK_F7:
						System.out.println("HoaDon");
						break;
					case KeyEvent.VK_F8:
						System.out.println("HDSD");
						break;
					default:
						// code block
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});
		this.add(container);
	}
	
	private JPanel navigationUI(String title) {
		JLabel lblTitle = new JLabel("<html><b style='color: #CD2653; font-size: 20; font-weight: 900'>"+ title +"</b></html>");
		JPanel nav = new JPanel();
		nav.setPreferredSize(new Dimension(WIDTH - WIDTH/7, 70));
		nav.setBackground(new Color(0, 0, 0, 0));
		nav.add(lblTitle);
		return nav;
	}
	
	private JPanel sideBarUI() {
		JPanel sideBar = new JPanel(new BorderLayout());
		JPanel top = new JPanel();
		JPanel center = new JPanel(new GridLayout(8, 1, 0, 10));
		JPanel bottom = new JPanel();
		Box user = Box.createHorizontalBox();
		Box userInfo = Box.createVerticalBox();
		
		sideBar.add(top, BorderLayout.NORTH);
		sideBar.add(center, BorderLayout.CENTER);
		sideBar.add(bottom, BorderLayout.SOUTH);
		
		top.setPreferredSize(new Dimension(WIDTH/6, 100));
		bottom.setPreferredSize(new Dimension(WIDTH/6, 50));
		sideBar.setPreferredSize(new Dimension(WIDTH/6, HEIGHT));
		user.setPreferredSize(new Dimension(200, 80));
		
		Color backgroundColorSideBar = Color.decode("#CD2653");
		Color backgroundColorUser = Color.decode("#F8A4BB");
		sideBar.setBackground(backgroundColorSideBar);
		top.setBackground(backgroundColorSideBar);
		bottom.setBackground(backgroundColorSideBar);
		center.setBackground(backgroundColorSideBar);
		user.setBackground(backgroundColorUser);
		userInfo.setBackground(backgroundColorUser);
		String[] title = {"BÁN HÀNG (F1)", "KHÁCH HÀNG (F2)", "NHÂN VIÊN (F3)", "QUẦN ÁO (F4)"
				,"NHÀ CUNG CẤP (F5)", "THỐNG KÊ (F6)", "HOÁ ĐƠN (F7)", "HƯỚNG DẪN SỬ DỤNG (F8)"};
		String rootPath = "img/icon/";
		String fileExplorer = ".png";
		String[] fileName = {"shopping-cart", "customer", "staff", "clothers", "supplier", "statistics", "bill", "help"};
		for (int i = 0; i < title.length; i++) {
			String filePath = rootPath + fileName[i] + fileExplorer;
			ImageIcon icon = new ImageIcon(createImage(filePath, 30, 30));
			Box menuBox = createMenuBox(icon, title[i]);
			menuBox.addMouseListener(createHoverEffect(menuBox));
			center.add(menuBox);
			int finalI = i;
			menuBox.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent e) {
					switch (finalI) {
						case 0:
							System.out.println("Ban Hang");
							break;
						case 1:
							System.out.println("khach Hang");
							break;
						case 2:
							System.out.println("NhanVien");
							break;
						case 3:
							System.out.println("QuanAo");
							break;
						case 4:
							System.out.println("NCC");
							break;
						case 5:
							System.out.println("Thong ke");
							break;
						case 6:
							System.out.println("HoaDon");
							break;
						case 7:
							System.out.println("HDSD");
							break;
						default:
							// code block
					}
				}

				@Override
				public void mousePressed(MouseEvent e) {

				}

				@Override
				public void mouseReleased(MouseEvent e) {

				}

				@Override
				public void mouseEntered(MouseEvent e) {

				}

				@Override
				public void mouseExited(MouseEvent e) {

				}
			});

		}

		ImageIcon userIcon = new ImageIcon(createImage("img/icon/user.png", 50, 50));
		JLabel userLabel = new JLabel(userIcon);
		JLabel userName = new JLabel("{username}");
		JLabel userPosition = new JLabel("- {role}");
		userName.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));
		userPosition.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));
		user.add(userLabel);
		user.add(Box.createHorizontalStrut(10));
		user.add(userInfo);
		userInfo.add(userName);
		userInfo.add(userPosition);
		top.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		top.add(user);
		return sideBar;
	}
	
	public abstract JPanel contentUI();
//		JPanel content = new JPanel(new BorderLayout());
//		content.setBackground(new Color(0, 0, 0, 0));
//		return content;
	
	//Additional Functions
	private Box createMenuBox(ImageIcon icon, String title) {
		Box box = Box.createHorizontalBox();
		Box titleBox = Box.createVerticalBox();
		JLabel iconLabel = new JLabel(icon);
		JLabel titleLabel = new JLabel("<html><b style='color: #ffffff; font-size: 12'>" + title + "</b></html>");

		box.add(Box.createHorizontalStrut(10));
		box.add(iconLabel);
		box.add(Box.createHorizontalStrut(5));
		titleBox.add(Box.createVerticalStrut(17));
		titleBox.add(titleLabel);
		box.add(titleBox);
		
		box.setBackground(Color.decode("#CD2653"));
        box.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        box.setForeground(Color.WHITE);
        box.setCursor(new Cursor(Cursor.HAND_CURSOR));
        box.setOpaque(true);
		return box;
	}
	private Image createImage(String imagePath, int width, int height) {
		 try {
			BufferedImage originalImage = ImageIO.read(new FileInputStream(imagePath));
	        BufferedImage resizedImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	        Graphics2D g2 = resizedImg.createGraphics();
	        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	        g2.drawImage(originalImage, 0, 0, width, height, null);
	        g2.dispose();
	        return resizedImg;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	private static MouseAdapter createHoverEffect(Box box) {
        return new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                box.setBackground(Color.decode("#FF5885")); // Change background color on hover
                box.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                box.setBackground(Color.decode("#CD2653")); // Restore original background color
                box.repaint();
            }
        };
    }
}
