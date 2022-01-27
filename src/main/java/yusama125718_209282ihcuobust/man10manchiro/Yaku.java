package yusama125718_209282ihcuobust.man10manchiro;

import java.util.ArrayList;

import static yusama125718_209282ihcuobust.man10manchiro.Game.*;

public class Yaku extends Thread
{
    @Override
    public synchronized void run()
    {
        assert Game.getInstance() != null;
        yakuhanntei: switch (outnumber.get(0))
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
                                break yakuhanntei;
                            }
                            case 2:
                            {
                                yaku = 12;
                                yakuname = "イチのニ";
                                break yakuhanntei;
                            }
                            case 3:
                            {
                                yaku = 13;
                                yakuname = "イチのサン";
                                break yakuhanntei;
                            }
                            case 4:
                            {
                                yaku = 14;
                                yakuname = "イチのヨン";
                                break yakuhanntei;
                            }
                            case 5:
                            {
                                yaku = 15;
                                yakuname = "イチのゴ";
                                break yakuhanntei;
                            }
                            case 6:
                            {
                                yaku = 16;
                                yakuname = "イチのロク";
                                break yakuhanntei;
                            }
                        }
                    }
                    case 2:
                    {
                        switch (outnumber.get(2))
                        {
                            case 2:
                            {
                                yaku = 11;
                                yakuname = "ニのイチ";
                                break yakuhanntei;
                            }
                            case 3:
                            {
                                yaku = 1;
                                yakuname = "ヒフミ";
                                break yakuhanntei;
                            }
                            default:
                            {
                                yaku = 2;
                                yakuname = "役無し";
                                break yakuhanntei;
                            }
                        }
                    }
                    case 3:
                    {
                        switch (outnumber.get(2))
                        {
                            case 3:
                            {
                                yaku = 11;
                                yakuname = "サンのイチ";
                                break yakuhanntei;
                            }
                            default:
                            {
                                yaku = 2;
                                yakuname = "役無し";
                                break yakuhanntei;
                            }
                        }
                    }
                    case 4:
                    {
                        switch (outnumber.get(2))
                        {
                            case 4:
                            {
                                yaku = 11;
                                yakuname = "ヨンのイチ";
                                break yakuhanntei;
                            }
                            default:
                            {
                                yaku = 2;
                                yakuname = "役無し";
                                break yakuhanntei;
                            }
                        }
                    }
                    case 5:
                    {
                        switch (outnumber.get(2))
                        {
                            case 5:
                            {
                                yaku = 11;
                                yakuname = "ゴのイチ";
                                break yakuhanntei;
                            }
                            case 6:
                            {
                                yaku = 2;
                                yakuname = "役無し";
                                break yakuhanntei;
                            }
                        }
                    }
                    case 6:
                    {
                        yaku = 11;
                        yakuname = "ロクのイチ";
                        break yakuhanntei;
                    }
                }
            }
            case 2:
            {
                switch (outnumber.get(1))
                {
                    case 2:
                    {
                        switch (outnumber.get(2))
                        {
                            case 2:
                            {
                                yaku = 110;
                                yakuname = "二のゾロ目";
                                break yakuhanntei;
                            }
                            case 3:
                            {
                                yaku = 13;
                                yakuname = "二のサン";
                                break yakuhanntei;
                            }
                            case 4:
                            {
                                yaku = 14;
                                yakuname = "二のヨン";
                                break yakuhanntei;
                            }
                            case 5:
                            {
                                yaku = 15;
                                yakuname = "二のゴ";
                                break yakuhanntei;
                            }
                            case 6:
                            {
                                yaku = 16;
                                yakuname = "二のロク";
                                break yakuhanntei;
                            }
                        }
                    }
                    case 3:
                    {
                        switch (outnumber.get(2))
                        {
                            case 3:
                            {
                                yaku = 12;
                                yakuname = "サンのニ";
                                break yakuhanntei;
                            }
                            default:
                            {
                                yaku = 2;
                                yakuname = "役無し";
                                break yakuhanntei;
                            }
                        }
                    }
                    case 4:
                    {
                        switch (outnumber.get(2))
                        {
                            case 4:
                            {
                                yaku = 12;
                                yakuname = "ヨンのニ";
                                break yakuhanntei;
                            }
                            default:
                            {
                                yaku = 2;
                                yakuname = "役無し";
                                break yakuhanntei;
                            }
                        }
                    }
                    case 5:
                    {
                        switch (outnumber.get(2))
                        {
                            case 5:
                            {
                                yaku = 12;
                                yakuname = "ゴのニ";
                                break yakuhanntei;
                            }
                            case 6:
                            {
                                yaku = 2;
                                yakuname = "役無し";
                                break yakuhanntei;
                            }
                        }
                    }
                    case 6:
                    {
                        yaku = 12;
                        yakuname = "ロクのニ";
                        break yakuhanntei;
                    }
                }
            }
            case 3:
            {
                switch (outnumber.get(1))
                {
                    case 3:
                    {
                        switch (outnumber.get(2))
                        {
                            case 3:
                            {
                                yaku = 109;
                                yakuname = "サンのゾロ目";
                                break yakuhanntei;
                            }
                            case 4:
                            {
                                yaku = 14;
                                yakuname = "サンのヨン";
                                break yakuhanntei;
                            }
                            case 5:
                            {
                                yaku = 15;
                                yakuname = "サンのゴ";
                                break yakuhanntei;
                            }
                            case 6:
                            {
                                yaku = 16;
                                yakuname = "サンのロク";
                                break yakuhanntei;
                            }
                        }
                    }
                    case 4:
                    {
                        switch (outnumber.get(2))
                        {
                            case 4:
                            {
                                yaku = 13;
                                yakuname = "ヨンのサン";
                                break yakuhanntei;
                            }
                            default:
                            {
                                yaku = 2;
                                yakuname = "役無し";
                                break yakuhanntei;
                            }
                        }
                    }
                    case 5:
                    {
                        switch (outnumber.get(2))
                        {
                            case 5:
                            {
                                yaku = 13;
                                yakuname = "ゴのヨン";
                                break yakuhanntei;
                            }
                            case 6:
                            {
                                yaku = 2;
                                yakuname = "役無し";
                                break yakuhanntei;
                            }
                        }
                    }
                    case 6:
                    {
                        yaku = 13;
                        yakuname = "ロクのサン";
                        break yakuhanntei;
                    }
                }
            }
            case 4:
            {
                switch (outnumber.get(1))
                {
                    case 4:
                    {
                        switch (outnumber.get(2))
                        {
                            case 4:
                            {
                                yaku = 108;
                                yakuname = "ヨンのゾロ目";
                                break yakuhanntei;
                            }
                            case 5:
                            {
                                yaku = 15;
                                yakuname = "ヨンのゴ";
                                break yakuhanntei;
                            }
                            case 6:
                            {
                                yaku = 16;
                                yakuname = "ヨンのロク";
                                break yakuhanntei;
                            }
                        }
                    }
                    case 5:
                    {
                        switch (outnumber.get(2))
                        {
                            case 5:
                            {
                                yaku = 14;
                                yakuname = "ゴのヨン";
                                break yakuhanntei;
                            }
                            case 6:
                            {
                                yaku = 45;
                                yakuname = "シゴロ";
                                break yakuhanntei;
                            }
                        }
                    }
                    case 6:
                    {
                        yaku = 14;
                        yakuname = "ロクのヨン";
                        break yakuhanntei;
                    }
                }
            }
            case 5:
            {
                switch (outnumber.get(1))
                {
                    case 5:
                    {
                        switch (outnumber.get(2))
                        {
                            case 5:
                            {
                                yaku = 107;
                                yakuname = "ゴのゾロ目";
                                break yakuhanntei;
                            }
                            case 6:
                            {
                                yaku = 16;
                                yakuname = "ゴのロク";
                                break yakuhanntei;
                            }
                        }
                    }
                    case 6:
                    {
                        yaku = 15;
                        yakuname = "ロクのゴ";
                        break yakuhanntei;
                    }
                }
            }
            case 6:
            {
                yaku = 106;
                yakuname = "ロクのゾロ目";
                break yakuhanntei;
            }
        }
    }
}
