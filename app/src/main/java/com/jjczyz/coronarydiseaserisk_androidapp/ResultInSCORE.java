package com.jjczyz.coronarydiseaserisk_androidapp;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Hatsam on 2017-03-16.
 */
public class ResultInSCORE implements Serializable{

    private ArrayList<Question> questions;
    private int[][][][][] result = new int[2][2][5][4][5];
    private int[] scoreTable = {0,0,0,0,0,      0,0,0,0,0,      0,0,1,1,1,      1,1,1,1,1,
                                1,1,1,1,1,      1,1,1,1,1,      1,1,2,2,2,      2,2,2,3,3,
                                1,1,1,2,2,      1,2,2,2,3,      2,2,3,3,4,      3,3,4,4,5,
                                2,2,2,3,3,      2,3,4,4,5,      4,4,5,6,7,      5,6,7,9,10,
                                3,4,5,6,7,      5,6,7,8,10,     7,8,10,12,14,   10,12,14,17,20,

                                0,0,0,1,1,      1,1,1,1,1,      1,1,1,1,1,      1,1,1,2,2,
                                1,1,1,2,2,      2,2,2,3,3,      2,3,3,4,4,      3,4,4,5,6,
                                2,2,3,3,4,      3,3,4,4,5,      4,4,5,6,7,      5,6,8,9,11,
                                3,4,5,6,7,      5,6,7,8,10,     7,9,10,12,14,   10,12,14,17,20,
                                7,8,10,12,14,   10,12,14,16,19, 14,17,19,23,27, 20,23,27,31,36,


                                1,1,1,1,1,      1,1,1,2,2,      1,2,2,2,3,      2,2,3,3,4,
                                2,2,2,3,4,      3,3,4,4,5,      4,4,5,6,7,      5,6,7,8,10,
                                3,3,4,5,5,      4,5,6,7,8,      6,7,8,9,11,     8,10,11,13,16,
                                4,5,6,7,9,      6,7,8,10,12,    9,10,12,15,17,  13,15,17,20,24,
                                7,8,10,12,14,   10,12,14,16,19, 14,17,19,23,27, 19,23,26,31,36,

                                1,2,2,2,3,      2,2,3,3,4,      3,3,4,4,5,      4,5,5,6,8,
                                4,4,5,6,7,      5,6,7,9,10,     7,9,10,12,14,   10,12,15,17,20,
                                6,7,8,9,11,     8,9,11,13,16,   11,13,16,18,22, 16,19,22,26,30,
                                9,10,12,14,17,  12,14,17,20,23, 17,20,24,28,32, 24,28,32,37,43,
                                14,16,19,22,26, 19,22,26,30,35, 26,31,35,41,46, 36,41,47,53,59};


    ResultInSCORE()
    {
        int sex, smk, age, sys, chl;
        for(sex=0; sex<2; sex++)
        {
            for(smk=0; smk<2; smk++)
            {
                for(age=0; age<5; age++)
                {
                    for(sys=0; sys<4; sys++)
                    {
                        for(chl=0; chl<5; chl++)
                        {
                            result[sex][smk][age][sys][chl] = scoreTable[chl + sys*5 + age*5*4 + smk*5*4*5 + sex*5*4*5*2];
                        }
                    }
                }
            }
        }
        questions = new ArrayList<>();
    }

    void createQuestions(Context c)
    {
        Resources res = c.getResources();
        TypedArray ta = res.obtainTypedArray(R.array.questionsAndAnswers);
        int alength = ta.length();
        String[][] QAArray = new String[alength][];
        for (int i = 0; i < alength; ++i) {
            int id = ta.getResourceId(i, 0);
            if (id > 0) {
                QAArray[i] = res.getStringArray(id);
            } else {
                // something wrong with the XML
            }
        }
        for (int i=0; i<QAArray[0].length; i++)
        {
            Question question = new Question(QAArray[0][i],QAArray[i+1]);
            questions.add(question);
        }
        ta.recycle();
    }

    public String getResult()
    {
        if(questions.get(4).getSelectedAnswerNum() == 5)
        {
            return (Integer.toString(result[questions.get(0).getSelectedAnswerNum()][questions.get(1).getSelectedAnswerNum()]
                            [questions.get(2).getSelectedAnswerNum()][questions.get(3).getSelectedAnswerNum()][0])
                    + "-" +
                    Integer.toString(result[questions.get(0).getSelectedAnswerNum()][questions.get(1).getSelectedAnswerNum()]
                            [questions.get(2).getSelectedAnswerNum()][questions.get(3).getSelectedAnswerNum()]
                            [4]));
        }
        return Integer.toString(result[questions.get(0).getSelectedAnswerNum()][questions.get(1).getSelectedAnswerNum()]
                               [questions.get(2).getSelectedAnswerNum()][questions.get(3).getSelectedAnswerNum()]
                               [questions.get(4).getSelectedAnswerNum()]);
    }

    Question getQuestion(int q)
    {
        return questions.get(q);
    }

    public int getQuestionsSize(){ return questions.size();}
}

class Question implements Serializable
{
    private String questionText;
    private String[] answers;
    private Integer selectedAnswerNum;

    Question(String q, String[] a)
    {
        this.questionText = q;
        this.answers = a;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public Integer getSelectedAnswerNum() {
        return selectedAnswerNum;
    }

    public void setSelectedAnswerNum(Integer selectedAnswerNum) {
        this.selectedAnswerNum = selectedAnswerNum;
    }
}
