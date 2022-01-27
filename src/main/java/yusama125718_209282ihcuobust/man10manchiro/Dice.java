package yusama125718_209282ihcuobust.man10manchiro;

import java.util.ArrayList;
import java.util.Random;

import static yusama125718_209282ihcuobust.man10manchiro.Game.yaku;

public class Dice extends Thread
{
    @Override
    public synchronized void start()
    {
        ArrayList<Integer> outnumber = (ArrayList<Integer>) Game.getInstance().getList();
        loop: for (int i = 0; i < 3; i++)
        {
            for (int i2 = 0; i2 < 3; i2++) //親のダイスロール
            {
                Random dicerondom = new Random();
                int diceoutnumber = dicerondom.nextInt(6) + 1;
                synchronized (outnumber)
                {
                    switch (outnumber.size())
                    {
                        case 0:
                        {
                            outnumber.add(diceoutnumber);
                        }
                        case 1:
                        {
                            if (diceoutnumber > outnumber.get(0))
                            {
                                outnumber.add(diceoutnumber);
                            }
                            else
                            {
                                outnumber.add(0,diceoutnumber);
                            }
                        }
                        case 2:
                        {
                            if (diceoutnumber > outnumber.get(0))
                            {
                                if (diceoutnumber > outnumber.get(1))
                                {
                                    outnumber.add(diceoutnumber);
                                }
                                else
                                {
                                    outnumber.add(1,diceoutnumber);
                                }
                            }
                            else
                            {
                                outnumber.add(0,diceoutnumber);
                            }
                        }
                    }
                }
            }
            Yaku yakuthread = new Yaku();
            yakuthread.start();
            try
            {
                yakuthread.join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            if (!(yaku == 0))
            {
                break loop;
            }
        }
    }
}
