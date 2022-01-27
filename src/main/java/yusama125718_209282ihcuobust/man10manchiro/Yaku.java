package yusama125718_209282ihcuobust.man10manchiro;

import java.util.ArrayList;
import static yusama125718_209282ihcuobust.man10manchiro.Game.yaku;
import static yusama125718_209282ihcuobust.man10manchiro.Game.yakuname;

public class Yaku extends Thread
{
    @Override
    public synchronized void start()
    {
        assert Game.getInstance() != null;
        ArrayList<Integer> outnumber = (ArrayList<Integer>) Game.getInstance().getList();
        switch (outnumber.get(0))
        {
            case 1:
            {
                switch (outnumber.get(1))
                {
                    case 1:
                    {
                        switch (outnumber.get(2))
                        {
                            case 1:
                            {
                                yaku = 111;
                                yakuname = "ピンゾロ";
                            }
                            case 2:
                            {
                                yaku = 12;
                                yakuname = "イチのニ";
                            }
                            case 3:
                            {
                                yaku = 13;
                                yakuname = "イチのサン";
                            }
                            case 4:
                            {
                                yaku = 14;
                                yakuname = "イチのヨン";
                            }
                            case 5:
                            {
                                yaku = 15;
                                yakuname = "イチのゴ";
                            }
                            case 6:
                            {
                                yaku = 16;
                                yakuname = "イチのロク";
                            }
                        }
                    }
                    case 2:
                    {
                        switch (outnumber.get(1))
                        {
                            case 2:
                            {
                                yaku = 11;
                                yakuname = "ニのイチ";
                            }
                            case 3:
                            {
                                yaku = 1;
                                yakuname = "ヒフミ";
                            }
                            case 4:
                            {
                                yaku = 2;
                                yakuname = "役無し";
                            }
                            case 5:
                            {
                                yaku = 2;
                                yakuname = "役無し";
                            }
                            case 6:
                            {
                                yaku = 2;
                                yakuname = "役無し";
                            }
                        }
                    }
                    case 3:
                    {
                        switch (outnumber.get(1))
                        {
                            case 3:
                            {
                                yaku = 11;
                                yakuname = "サンのイチ";
                            }
                            case 4:
                            {
                                yaku = 2;
                                yakuname = "役無し";
                            }
                            case 5:
                            {
                                yaku = 2;
                                yakuname = "役無し";
                            }
                            case 6:
                            {
                                yaku = 2;
                                yakuname = "役無し";
                            }
                        }
                    }
                    case 4:
                    {
                        switch (outnumber.get(1))
                        {
                            case 4:
                            {
                                yaku = 11;
                                yakuname = "ヨンのイチ";
                            }
                            case 5:
                            {
                                yaku = 2;
                                yakuname = "役無し";
                            }
                            case 6:
                            {
                                yaku = 2;
                                yakuname = "役無し";
                            }
                        }
                    }
                    case 5:
                    {
                        switch (outnumber.get(1))
                        {
                            case 5:
                            {
                                yaku = 11;
                                yakuname = "ゴのイチ";
                            }
                            case 6:
                            {
                                yaku = 2;
                                yakuname = "役無し";
                            }
                        }
                    }
                    case 6:
                    {
                        yaku = 11;
                        yakuname = "ロクのイチ";
                    }
                }
            }
            case 2:
            {
                switch (outnumber.get(1))
                {
                    case 2:
                    {
                        switch (outnumber.get(1))
                        {
                            case 2:
                            {
                                yaku = 110;
                                yakuname = "二のゾロ目";
                            }
                            case 3:
                            {
                                yaku = 13;
                                yakuname = "二のサン";
                            }
                            case 4:
                            {
                                yaku = 14;
                                yakuname = "二のヨン";

                            }
                            case 5:
                            {
                                yaku = 15;
                                yakuname = "二のゴ";
                            }
                            case 6:
                            {
                                yaku = 16;
                                yakuname = "二のロク";
                            }
                        }
                    }
                    case 3:
                    {
                        switch (outnumber.get(1))
                        {
                            case 3:
                            {
                                yaku = 12;
                                yakuname = "サンのニ";
                            }
                            case 4:
                            {
                                yaku = 2;
                                yakuname = "役無し";
                            }
                            case 5:
                            {
                                yaku = 2;
                                yakuname = "役無し";
                            }
                            case 6:
                            {
                                yaku = 2;
                                yakuname = "役無し";
                            }
                        }
                    }
                    case 4:
                    {
                        switch (outnumber.get(1))
                        {
                            case 4:
                            {
                                yaku = 12;
                                yakuname = "ヨンのニ";
                            }
                            case 5:
                            {
                                yaku = 2;
                                yakuname = "役無し";
                            }
                            case 6:
                            {
                                yaku = 2;
                                yakuname = "役無し";
                            }
                        }
                    }
                    case 5:
                    {
                        switch (outnumber.get(1))
                        {
                            case 5:
                            {
                                yaku = 12;
                                yakuname = "ゴのニ";
                            }
                            case 6:
                            {
                                yaku = 2;
                                yakuname = "役無し";
                            }
                        }
                    }
                    case 6:
                    {
                        yaku = 12;
                        yakuname = "ロクのニ";
                    }
                }
            }
            case 3:
            {
                switch (outnumber.get(1))
                {
                    case 3:
                    {
                        switch (outnumber.get(1))
                        {
                            case 3:
                            {
                                yaku = 109;
                                yakuname = "サンのゾロ目";
                            }
                            case 4:
                            {
                                yaku = 14;
                                yakuname = "サンのヨン";
                            }
                            case 5:
                            {
                                yaku = 15;
                                yakuname = "サンのゴ";
                            }
                            case 6:
                            {
                                yaku = 16;
                                yakuname = "サンのロク";
                            }
                        }
                    }
                    case 4:
                    {
                        switch (outnumber.get(1))
                        {
                            case 4:
                            {
                                yaku = 13;
                                yakuname = "ヨンのサン";
                            }
                            case 5:
                            {
                                yaku = 2;
                                yakuname = "役無し";
                            }
                            case 6:
                            {
                                yaku = 2;
                                yakuname = "役無し";
                            }
                        }
                    }
                    case 5:
                    {
                        switch (outnumber.get(1))
                        {
                            case 5:
                            {
                                yaku = 13;
                                yakuname = "ゴのヨン";
                            }
                            case 6:
                            {
                                yaku = 2;
                                yakuname = "役無し";
                            }
                        }
                    }
                    case 6:
                    {
                        yaku = 13;
                    }
                }
            }
            case 4:
            {
                switch (outnumber.get(1))
                {
                    case 4:
                    {
                        switch (outnumber.get(1))
                        {
                            case 4:
                            {
                                yaku = 108;
                                yakuname = "ヨンのゾロ目";
                            }
                            case 5:
                            {
                                yaku = 15;
                                yakuname = "ヨンのゴ";
                            }
                            case 6:
                            {
                                yaku = 16;
                                yakuname = "ヨンのロク";
                            }
                        }
                    }
                    case 5:
                    {
                        switch (outnumber.get(1))
                        {
                            case 5:
                            {
                                yaku = 14;
                                yakuname = "ゴのヨン";
                            }
                            case 6:
                            {
                                yaku = 45;
                                yakuname = "シゴロ";
                            }
                        }
                    }
                    case 6:
                    {
                        yaku = 14;
                        yakuname = "ロクのヨン";
                    }
                }
            }
            case 5:
            {
                switch (outnumber.get(1))
                {
                    case 5:
                    {
                        switch (outnumber.get(1))
                        {
                            case 5:
                            {
                                yaku = 107;
                                yakuname = "ゴのゾロ目";
                            }
                            case 6:
                            {
                                yaku = 16;
                                yakuname = "ゴのロク";
                            }
                        }
                    }
                    case 6:
                    {
                        yaku = 15;
                        yakuname = "ロクのゴ";
                    }
                }
            }
            case 6:
            {
                yaku = 106;
                yakuname = "ロクのゾロ目";
            }
        }
        outnumber.clear();
    }
}
