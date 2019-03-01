# -*- coding: utf-8 -*-
"""
Created on Fri Mar  1 00:57:34 2019

@author: Yi
"""

import cv2
import numpy as np

cv2.namedWindow('Window', cv2.WINDOW_NORMAL)
cap = cv2.VideoCapture(0)

pos_frame=-10;
out = cv2.VideoWriter('recording.mp4',cv2.VideoWriter_fourcc('M','J','P','G'), 10, (int(cap.get(3)),int(cap.get(4)))) 

while True:
    ret,frame = cap.read()
    
    if ret == True:
        pos_frame+=1;
        
        if(pos_frame<=50):
            frame=cv2.cvtColor(frame,cv2.COLOR_BGR2GRAY)
            frame=cv2.cvtColor(frame,cv2.COLOR_GRAY2RGB)

        elif(pos_frame>50 and pos_frame<=100):
            frame = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
            frame = cv2.GaussianBlur(frame,(51,51),0)
            #sigma is 51 now, increasing the value of sigma (widening the kernel) would make the it more smoothed
            frame=cv2.cvtColor(frame,cv2.COLOR_GRAY2RGB)
        
        elif(pos_frame>100 and pos_frame<=150):
            frame = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
            for i in range(20):
                frame=cv2.bilateralFilter(frame,3,75,75)
                #Rather than applying a large bilateral filter, applying many small bilateral filters would produce a strong cartoon effect in less time.
            frame=cv2.cvtColor(frame,cv2.COLOR_GRAY2RGB)
        
        elif(pos_frame>150 and pos_frame<=200):
            pass
        
        elif(pos_frame>200 and pos_frame<=250):
            b,g,r = cv2.split(frame)
            rg = r - g
            rb = r - b
            rg = np.clip(rg, 0, 255)
            rb = np.clip(rb, 0, 255)
            mask1 = cv2.inRange(rg, 50, 255)
            mask2 = cv2.inRange(rb, 50, 255)
            mask = cv2.bitwise_and(mask1, mask2)
            res=cv2.bitwise_and(frame,frame,mask=mask)
            frame=res

    
        elif(pos_frame>250 and pos_frame<=300):
            hsv=cv2.cvtColor(frame,cv2.COLOR_BGR2HSV)
            lower=np.array([0,60,70])
            upper=np.array([10,255,255])
            mask=cv2.inRange(hsv,lower,upper)
            res=cv2.bitwise_and(frame,frame,mask=mask)
            frame=res
            
            
        elif(pos_frame>300 and pos_frame<=350):

            hsv=cv2.cvtColor(frame,cv2.COLOR_BGR2HSV)
            lower=np.array([20,100,100])
            upper=np.array([30,255,255])
            mask=cv2.inRange(hsv,lower,upper)
            res=cv2.bitwise_and(frame,frame,mask=mask)
            ##################
            ##morphological operations
            kernel = np.ones((5,5),np.uint8)
            frame = cv2.dilate(res,kernel,iterations = 1)

        
        elif(pos_frame>350 and pos_frame<=600):
            gray=cv2.cvtColor(frame,cv2.COLOR_BGR2GRAY)
            circles= cv2.HoughCircles(gray,cv2.HOUGH_GRADIENT,1,100,param1=100,param2=30,minRadius=0,maxRadius=100)
            for circle in circles[0]:
                x=int(circle[0])
                y=int(circle[1])
                r=int(circle[2])
                frame=cv2.circle(frame,(x,y),r,(0,255,0),-1)     
            
        else:
            break

        out.write(frame)
        cv2.imshow('Window', frame)
        if cv2.waitKey(1) & 0xFF == ord('q'):
            break
    else:
        break

cap.release()
out.release()
cv2.destroyAllWindows()
