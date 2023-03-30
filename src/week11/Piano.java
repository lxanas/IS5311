package week11;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Piano extends JFrame
{
    private JLabel[] whiteKeys = new JLabel[16];
    private JLabel[] blackKeys = new JLabel[11];
    private final int whiteKeyWidth = 50;
    private final int blackKeyWidth = 25;
    private HashMap<Character, JLabel> whiteKeyMap;
    private HashMap<Character, JLabel> blackKeyMap;

    public Piano()
    {
        setTitle("Piano keyboard");
        setSize(whiteKeys.length * whiteKeyWidth, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(buildPanel());
        buildKeyMap();
        addKeyListener(new MyKeyListener());
        setVisible(true);
    }

    private JPanel buildPanel()
    {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JPanel bottomKeysPanel = new JPanel();
        bottomKeysPanel.setLayout(null);
        bottomKeysPanel.setBounds(0, 0, whiteKeys.length * whiteKeyWidth, 300);
        bottomKeysPanel.setOpaque(false);
        for (int i = 0; i < whiteKeys.length; i++)
        {
            whiteKeys[i] = new JLabel("");
            whiteKeys[i].setBounds(i * whiteKeyWidth - 1, 0, whiteKeyWidth -
                    2, 100);
            whiteKeys[i].setOpaque(true);
            whiteKeys[i].setBackground(Color.WHITE);
            bottomKeysPanel.add(whiteKeys[i]);
        }
        JPanel topKeysPanel = new JPanel();
        topKeysPanel.setLayout(null);
        topKeysPanel.setBounds(0, 0, whiteKeys.length * whiteKeyWidth, 300);
        topKeysPanel.setOpaque(false);
        int numKeysAndSpace = blackKeys.length + 4;
        int passedSpace = 0;
        for (int i = 0; i < numKeysAndSpace; i++)
        {
            if (i == 1 || i == 4 || i == 8 || i == 11)
            {
                passedSpace++;
            }
            else
            {
                blackKeys[i - passedSpace] = new JLabel();
                blackKeys[i - passedSpace].setOpaque(true);
                blackKeys[i - passedSpace].setBackground(Color.BLACK);
                blackKeys[i - passedSpace].setBounds(38 + i * whiteKeyWidth,
                        0, blackKeyWidth, 50);
                topKeysPanel.add(blackKeys[i - passedSpace]);
            }
        }
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setLayer(bottomKeysPanel, 1);
        layeredPane.setLayer(topKeysPanel, 2);
        layeredPane.add(bottomKeysPanel);
        layeredPane.add(topKeysPanel);
        layeredPane.setBounds(0, 0, whiteKeys.length * whiteKeyWidth, 300);
        layeredPane.setOpaque(true);
        panel.add(layeredPane);
        return panel;
    }

    private void buildKeyMap()
    {
        whiteKeyMap = new HashMap<Character, JLabel>();
        whiteKeyMap.put('z', whiteKeys[0]);
        whiteKeyMap.put('x', whiteKeys[1]);
        whiteKeyMap.put('c', whiteKeys[2]);
        whiteKeyMap.put('v', whiteKeys[3]);
        blackKeyMap = new HashMap<Character, JLabel>();
        blackKeyMap.put('s', blackKeys[0]);
        blackKeyMap.put('f', blackKeys[1]);
        blackKeyMap.put('g', blackKeys[2]);
    }

    private class MyKeyListener implements KeyListener
    {
        public void keyPressed(KeyEvent e)
        {
            JLabel mappedLabel = whiteKeyMap.get(e.getKeyChar());
            if (mappedLabel != null)
            {
                mappedLabel.setBackground(Color.YELLOW);
                return;
            }
            mappedLabel = blackKeyMap.get(e.getKeyChar());
            if (mappedLabel != null)
            {
                mappedLabel.setBackground(Color.YELLOW);
            }
        }

        public void keyReleased(KeyEvent e)
        {
            JLabel mappedLabel = whiteKeyMap.get(e.getKeyChar());
            if (mappedLabel != null)
            {
                mappedLabel.setBackground(Color.WHITE);
                return;
            }
            mappedLabel = blackKeyMap.get(e.getKeyChar());
            if (mappedLabel != null)
            {
                mappedLabel.setBackground(Color.BLACK);
            }
        }

        public void keyTyped(KeyEvent e)
        {
        }
    }

    public static void main(String[] main)
    {
        new Piano();
    }
}
