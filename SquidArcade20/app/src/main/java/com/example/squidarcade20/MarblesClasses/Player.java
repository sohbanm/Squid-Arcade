package com.example.squidarcade20.MarblesClasses;

public interface Player {
    String getGuess();

    public void setPlayerRole(String newRole);
    public int getMarbles();
    public void generateGamble();
    public void loseMarbles(int marblesLost);
    public void addMarbles(int marblesGained);
    public void setGamble(int gamble);
    public String getPlayerRole();
    public void newGuess();
    public void setResultText(String text);
    public String getResultText();

    void setGuess(String guess);

    public int getGamble();
}
