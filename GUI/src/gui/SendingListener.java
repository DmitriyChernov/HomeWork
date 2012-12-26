/*
 * Chernov Dmitriy
 * 271 group
 */

package gui;



public interface SendingListener 
{
    void sendingfinished(boolean success);
    void sendingbegin(String addr);
}

