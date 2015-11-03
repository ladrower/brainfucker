package brainfucker;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Frame
        extends JFrame
{
    public int level = 1;
    public int a = 0;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int result = 0;
    public int entered = 0;
    public int limit = 100;
    private JButton jButton1;
    private static JLabel jLabel1;
    private JLabel jLabel2;
    private JMenu jMenu1;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JSlider jSlider1;
    private static JTextField jTextField1;

    public Frame()
    {
        initComponents();
    }

    public void switchLevel()
    {
        this.level = this.jSlider1.getValue();
        switch (this.level)
        {
            case 0:
                this.limit = 10;
                this.jLabel2.setText("тьфу");
                break;
            case 1:
                this.limit = 100;
                this.jLabel2.setText("легко");
                break;
            case 2:
                this.limit = 1000;
                this.jLabel2.setText("неплохо");
                break;
            case 3:
                this.limit = 100;
                this.jLabel2.setText("нормально");
                break;
            case 4:
                this.limit = 1000;
                this.jLabel2.setText("хорошо");
                break;
            case 5:
                this.limit = 1000;
                this.jLabel2.setText("круто");
        }
        generateProblem();
        jTextField1.setText(null);
        jTextField1.setEditable(true);
    }

    public void generateProblem()
    {
        Random generator = new Random();
        switch (this.level)
        {
            case 0:
            case 1:
            case 2:
                this.a = generateInteger(this.limit);
                this.b = generateInteger(this.limit);
                this.result = (this.a + this.b);
                jLabel1.setText(this.a + " + " + this.b);
                break;
            case 3:
                this.a = generateInteger(this.limit);
                this.b = generateInteger(this.limit);
                this.c = generateInteger(10);
                switch (generator.nextInt(4))
                {
                    case 0:
                        this.result = (this.a + this.b - this.c);
                        jLabel1.setText(this.a + " + " + this.b + " - " + this.c);
                        break;
                    case 1:
                        this.result = (this.a - this.b + this.c);
                        jLabel1.setText(this.a + " - " + this.b + " + " + this.c);
                        break;
                    case 2:
                        this.d = generateInteger(100);
                        this.result = (this.b + this.a - this.c * this.d);
                        jLabel1.setText(this.b + " + " + this.a + " - " + this.c + " x " + this.d);
                        break;
                    case 3:
                        this.d = generateInteger(100);
                        this.result = (this.d * this.c - this.a + this.b);
                        jLabel1.setText(this.d + " x " + this.c + " - " + this.a + " + " + this.b);
                }
                break;
            case 4:
                this.a = generateInteger(this.limit);
                this.b = generateInteger(this.limit);
                this.c = generateInteger(20);
                this.d = generateInteger(10);
                switch (generator.nextInt(4))
                {
                    case 0:
                        this.result = (this.a + this.b - this.c);
                        jLabel1.setText(this.a + " + " + this.b + " - " + this.c);
                        break;
                    case 1:
                        this.result = (this.a - this.b + this.c);
                        jLabel1.setText(this.a + " - " + this.b + " + " + this.c);
                        break;
                    case 2:
                        this.result = (this.b + this.a - this.c * this.d);
                        jLabel1.setText(this.b + " + " + this.a + " - " + this.c + " x " + this.d);
                        break;
                    case 3:
                        this.result = (this.d * this.c - this.a + this.b);
                        jLabel1.setText(this.d + " x " + this.c + " - " + this.a + " + " + this.b);
                }
                break;
            case 5:
                this.a = generateInteger(this.limit);
                this.b = generateInteger(26);
                this.c = generateInteger(16);
                switch (generator.nextInt(5))
                {
                    case 0:
                        this.d = generateInteger(this.limit);
                        this.result = (this.a + this.b * this.c - this.d);
                        jLabel1.setText(this.a + " + " + this.b + " x " + this.c + " - " + this.d);
                        break;
                    case 1:
                        this.d = generateInteger(this.limit);
                        this.result = (this.d + this.a - this.c * this.b);
                        jLabel1.setText(this.d + " + " + this.a + " - " + this.c + " x " + this.b);
                        break;
                    case 2:
                        this.d = generateInteger(100);
                        this.result = (this.b + this.a - this.c * this.d);
                        jLabel1.setText(this.b + " + " + this.a + " - " + this.c + " x " + this.d);
                        break;
                    case 3:
                        this.d = generateInteger(100);
                        this.result = (this.a - this.b + this.d * this.c);
                        jLabel1.setText(this.a + " - " + this.b + " + " + this.d + " x " + this.c);
                        break;
                    case 4:
                        this.d = generateInteger(100);
                        this.result = (this.c * this.d + this.a - this.b);
                        jLabel1.setText(this.c + " x " + this.d + " + " + this.a + " - " + this.b);
                }
                break;
        }
    }

    public int generateInteger(int max)
    {
        Random generator = new Random();
        int value = generator.nextInt(max);
        while (value == 0) {
            value = generator.nextInt(max);
        }
        return value;
    }

    public boolean checkResult()
    {
        try
        {
            this.entered = Integer.parseInt(jTextField1.getText());
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return this.entered == this.result;
    }

    public void handleAnswer()
    {
        if (checkResult())
        {
            generateProblem();
            jTextField1.setText(null);
        }
        else
        {
            Toolkit.getDefaultToolkit().beep();
        }
        jTextField1.setEditable(true);
        jTextField1.requestFocusInWindow();
    }

    public void assignListeners()
    {
        jTextField1.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent e)
            {
                Frame.jTextField1.setEditable(false);
                int keyCode = e.getKeyCode();
                char keyChar = e.getKeyChar();
                int[] numKeys = { 222, 44, 46, 47, 75, 76, 59, 73, 79, 80 };
                Integer number = null;
                try
                {
                    number = Integer.parseInt(keyChar + "");
                }
                catch (Exception ex)
                {
                    System.out.println(ex);
                }
                for (int i = 0; i < numKeys.length; i++) {
                    if (numKeys[i] == keyCode) {
                        number = Frame.this.generateNumber(keyCode);
                    }
                }
                if (number != null) {
                    Frame.jTextField1.setText(Frame.jTextField1.getText() + number);
                }
                switch (keyCode)
                {
                    case 10:
                        Frame.this.handleAnswer();
                        break;
                    case 8:
                        Frame.jTextField1.setEditable(true);
                        break;
                    case 38:
                        if (Frame.this.jSlider1.getValue() < Frame.this.jSlider1.getMaximum()) {
                            Frame.this.jSlider1.setValue(Frame.this.jSlider1.getValue() + 1);
                        }
                        break;
                    case 40:
                        if (Frame.this.jSlider1.getValue() > Frame.this.jSlider1.getMinimum()) {
                            Frame.this.jSlider1.setValue(Frame.this.jSlider1.getValue() - 1);
                        }
                        break;
                }
            }
        });
    }

    public Integer generateNumber(int keyCode)
    {
        switch (keyCode)
        {
            case 44:
                return 1;
            case 46:
                return 2;
            case 47:
                return 3;
            case 75:
                return 4;
            case 76:
                return 5;
            case 59:
                return 6;
            case 73:
                return 7;
            case 79:
                return 8;
            case 80:
                return 9;
        }
        return 0;
    }

    public void takeYourTime()
    {
        setVisible(false);
        Timer timer = new Timer(60000, new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Frame.this.wakeUp();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    public void wakeUp()
    {
        setVisible(true);
        jTextField1.setEditable(true);
    }

    private void initComponents()
    {
        jLabel1 = new JLabel();
        jTextField1 = new JTextField();
        this.jButton1 = new JButton();
        this.jSlider1 = new JSlider();
        this.jLabel2 = new JLabel();
        this.jMenuBar1 = new JMenuBar();
        this.jMenu1 = new JMenu();
        this.jMenuItem1 = new JMenuItem();
        this.jMenuItem2 = new JMenuItem();

        setDefaultCloseOperation(3);

        jLabel1.setFont(new Font("Tahoma", 1, 24));
        jLabel1.setHorizontalAlignment(0);
        jLabel1.setText("a + b");

        jTextField1.setBackground(new Color(255, 255, 255));
        jTextField1.setFont(new Font("Tahoma", 0, 18));

        this.jButton1.setFont(new Font("Tahoma", Font.PLAIN, 24));
        this.jButton1.setText("Ответить");
        this.jButton1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                Frame.this.jButton1ActionPerformed(evt);
            }
        });
        this.jSlider1.setMajorTickSpacing(1);
        this.jSlider1.setMaximum(5);
        this.jSlider1.setMinorTickSpacing(1);
        this.jSlider1.setOrientation(1);
        this.jSlider1.setPaintTicks(true);
        this.jSlider1.setSnapToTicks(true);
        this.jSlider1.setToolTipText("Уровень сложности");
        this.jSlider1.setValue(1);
        this.jSlider1.setCursor(new Cursor(12));
        this.jSlider1.setFocusable(false);
        this.jSlider1.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent evt)
            {
                Frame.this.jSlider1StateChanged(evt);
            }
        });
        this.jLabel2.setHorizontalAlignment(0);
        this.jLabel2.setText("Легко");

        this.jMenu1.setText("Опции");

        this.jMenuItem1.setAccelerator(KeyStroke.getKeyStroke(82, 2));
        this.jMenuItem1.setText("Хочу отдохнуть");
        this.jMenuItem1.setToolTipText("Минутный перерыв");
        this.jMenuItem1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                Frame.this.jMenuItem1ActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jMenuItem1);
        this.jMenuItem1.getAccessibleContext().setAccessibleDescription("");

        this.jMenuItem2.setAccelerator(KeyStroke.getKeyStroke(70, 2));
        this.jMenuItem2.setText("Да пошел ты!");
        this.jMenuItem2.setToolTipText("Вежливо покинуть программу");
        this.jMenuItem2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                Frame.this.jMenuItem2ActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jMenuItem2);

        this.jMenuBar1.add(this.jMenu1);

        setJMenuBar(this.jMenuBar1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jSlider1, -1, 57, 32767).addComponent(this.jLabel2, -1, 57, 32767)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jLabel1, -1, 331, 32767).addComponent(jTextField1, -1, 331, 32767).addComponent(this.jButton1, -1, 331, 32767)).addContainerGap()));

        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jLabel1, -2, 25, -2).addComponent(this.jLabel2, -2, 14, -2)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(jTextField1, -2, 31, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jButton1, -1, 116, 32767)).addComponent(this.jSlider1, -1, 153, 32767)).addContainerGap()));

        this.jSlider1.getAccessibleContext().setAccessibleName("");

        pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt)
    {
        handleAnswer();
    }

    private void jMenuItem1ActionPerformed(ActionEvent evt)
    {
        takeYourTime();
    }

    private void jMenuItem2ActionPerformed(ActionEvent evt)
    {
        System.exit(0);
    }

    private void jSlider1StateChanged(ChangeEvent evt)
    {
        switchLevel();
    }
}
