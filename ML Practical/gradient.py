x=2 #variable intialize
lr=0.0031 #learning rate at actual(0.01) if greater than overshot
precision=0.000001 #iteration difference pre stepsize difference
previous_step_size=1 
max_iter=10000
iter=0
gf=lambda x:(x+3)**2

gd=[]

while precision<previous_step_size and iter<max_iter:
    prv=x #previous x and next x difference
    x=x-lr*gf(prv) 
    previous_step_size=abs(x-prv)
    iter+=1
    print("iteration",iter,"value",x)
    gd.append(x)


import matplotlib.pyplot as plt
plt.plot(gd)
