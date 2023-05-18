package study.domain;

import java.util.ArrayList;
import java.util.List;

public class LotteryContainer {

    private int lotteryCount = 0;
    private boolean isGameDone = false;
    private List<Integer> winNumbers;
    
    private List<Lottery> lotteryList = new ArrayList<>();
    
    private int[] winner = {0,0,0,0,0,0};

    public LotteryContainer(int lotteryCount) {
        this.lotteryCount = lotteryCount;
        for (int i = 0; i < this.lotteryCount; i++) {
            lotteryList.add(new Lottery());
        }
    }


    public List<Lottery> getTotalLottery() {
        return this.lotteryList;
    }


    public int getLotteryCount() {
        return this.lotteryCount;
    }


    public void setWinNumbers(List<Integer> winNumbers) {
        if (winNumbers == null) {
            throw new IllegalArgumentException("당첨 번호를 입력해주세요");
        }

        if (winNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호 6자리를 입력해주세요");
        }

        if (this.winNumbers != null) {
            throw new IllegalArgumentException("이미 당첨번호가 존재합니다");
        }

        this.winNumbers = winNumbers;
    }


    public void runGame() {
        if (this.winNumbers == null) {
            throw new IllegalArgumentException("당첨 번호를 입력 해주세요");
        }

        if (this.isGameDone) {
            throw new IllegalArgumentException("이미 진행된 게임입니다");
        }

        this.isGameDone = true;

        for (Lottery lotto : this.lotteryList) {
            lotto.setWinNumbers(winNumbers);

            int matchCount = lotto.getMatchCount();
            winner[matchCount]++;
        }
    }


    public int[] getWinnerList() {
        if (!this.isGameDone) {
            throw new IllegalArgumentException("게임이 진행되지 않았습니다");
        }

        return this.winner;
    }

}