# Open Control Protocol

OCP is a simple and fast protocol for controlling devices over any text capable method such as serial.

  - Simple text based standard
  - No connection initialisation required 
  - Extremely Lightweight
  - Easy to implement

### Version
No official version

> We are currently working towards a completed format, we are still coming up with new use cases.

### Tech
It is quite simple! The protocol is 100% text based to allow for extremely high comparability with new and old devices. We are designing the system to be as light weight as possibile to allow it to be used on devices such as Arduinos which have low specs.

The basic format is as follows:
```
<target:sender:command:tag:data>
```
The target is the device you are targeting, you require this in-case of environments where hubs are in use, you can send it to all devices via the ```*```

The send is just the device that sent it so the response can make its way back

The command is what you want to call, an example would be ```status``` or ```identify```. Do NOT forget that the command ```response``` is reserved for the response of each call, in most cases the data will just be ```ok``` for a response.

The tag is very important, it tells the other end what it should send in the response to ensure they responses do not get mixed up. The tag can be anything but should be unique to that call, it can be reused once the response has been used as this is how you tell which response is for which call.

The rest of it is just the call data, it can be anything in any format.

>IMPORTANT: You must not use ```<``` or ```>``` in any part of the call! If you do, you can trigger it to think the call is finished half way through. You should also not use ```\``` until you have checked the end devices capabilities as there are two different ways to send ```\```!
>
>Some devices may support the use ```\``` to escape the use of the next character, please check the device capabilities first! Do not assume either way, as you will get bad results either way.

Example request:
```
<computermanager:computerclient1234:register:p0:name=Test PC 1,capabilities=status,power,powerled,reset,hddstatus,cutpower>
```

Example response:
```
<computerclient1234:computermanager:response:p0:statu=ok>
```

### Universal Commands
These are commands that all devices must implement to ensure basic comparability and the ability to detect the end devices.

> These are coming soon! Check back later!

### Development

Want to contribute? Great! Just try and follow the same coding standards as the rest of the project then just make a pull request and it will probably get pulled!

Recommended tools:
 - Notepad++
 - Eclipse
 - Atmel Studio
 - Visual Studio + ReSharper

### Todo's

 - Continue readme
 - Create the wiki
 - Complete the basic tools and examples

License
----

Copyright (C) 2015 Error22
GNU GENERAL PUBLIC LICENSE Version 2, June 1991
