# Comparison of Event Handlers and Listeners
## This document will discuss Event Handlers / Listeners for Java and Swift.

## Java's Event Handlers / Listeners
Java handles events by having event handler classes. This are classes that implement the Action Listener interface. To set up an event handler you must first create a class which will handle the event and implement Action Listener or extends a class that implements Action Listener. Next you will add an instance of this class to a component such as a button. The event handling class will need to have implemented the action Performed method. This is the only method in the Action Listener interface making it a functional interface. The code defined in this method will be executed every time an action event object is received. Please see below for a functional example.
### Implmentation Of Event Handler Class And Action Listener Interface
```
public class AL extends Frame implements WindowListener,ActionListener {
        TextField text = new TextField(20);
        Button b;
        private int numClicks = 0;

        public static void main(String[] args) {
                AL myWindow = new AL("My first window");
                myWindow.setSize(350,100);
                myWindow.setVisible(true);
        }

        public AL(String title) {

                super(title);
                setLayout(new FlowLayout());
                b = new Button("Click me");
                add(b);
                add(text);
                b.addActionListener(this);
        }

        public void actionPerformed(ActionEvent e) {
                clickCount++;
                text.setText("Button Clicked " + clickCount + " time(s)");
        }
}
```
Sample code found on [Oracle Docs](https://docs.oracle.com/javase/tutorial/uiswing/events/actionlistener.html)

## Swift's Event Handlers / Listener (NSNotification)
During my research, I found that no all classes have delegate or event handlers / listener associated with them. However, I did find that most articles suggested using the NSNotication framework to name native event handlers and listeners for projects. This works by getting the default notification center (see example). Next step is to add an observer which waits for a post message addressed to the observer. After a post message is sent to the observer the target method is called. Information can be sent along with the post using the userInfo section of the post. After the observer receives the notification it can either act as in the example below or a *using:* section can be set up to call a different method altogether. 
### Implementation of NSNotification
```
let nc = NotificationCenter.default
nc.addObserver(forName:Notification.Name(rawValue:"MyNotification"),
               object:nil, queue:nil) {
  notification in
  // Handle notification
}

//To sent a message to the observer we use the following
nc.post(name:Notification.Name(rawValue:"MyNotification"),
        object: nil,
        userInfo: [User data here])
```
Sample code found on [Iachieved.it](http://dev.iachieved.it/iachievedit/notifications-and-userinfo-with-swift-3-0/)

## Conclusion
Both of these languages implement event handling similarly. The big difference I found is that Java uses a functional interface to make a class an event handler and objects which listen for changes on an object. Swift on the other hand uses a framework which centralizes all observers and manages their posts(messages) accordingly calling the correct method or allowing the observer to manage itself depending on how the code is written. While now Java has multiple classes with built in support of event handling and listeners making it very easy to use but limiting unless you create a whole new event handling class or us a lambda expression to create wanted functionality. Swift on the other hand starts off with you needing to write your event handling it does not require you to write an entire class to do so. Also with all observers in a centralized place they can be added and removed throughout the code with relative ease. I would say that Swift's current method of handling events is better than Java's but at the same time I feel that Swift could use more native event handling method on current classes. 

