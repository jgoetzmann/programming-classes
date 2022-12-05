import random ## imports random library

EIGHTBALL_LENGTH = 20

eightBall = {
    1 : ('you should, clear as rishay\'s face', True),
    2 : ('you should and yile should too', True),
    3 : ('you shouldnt and so yile shouldnt either', False),
    4 : ('im unsure just like Jai sharma\'s tesla investments', False),
    5 : ('just like thaddeous YES!!!', True),
    6 : ('answer is unclear like my GPA', False),
    7 : ('No', False),
    8 : ('Vehd Says No', False),
    9 : ('being the smartest thing here, take my advice, no', False),
    10 : ('this would be your biggest mistake of your life', False),
    11 : ('you miss every opportunity you dont take', True),
    12 : ('IM WINNING (and you will be soon too if you do that)', True),
    13 : ('I hate python so you shouldnt', False),
    14 : ('I hate python so you should', True),
    15 : ('yesssssssssssssssssssssssssssssssssssssssssssssssssssssssssss', True),
    16 : ('Vehd Says yes', True),
    17 : ('No is shorter than yes so No', False),
    18 : ('Yes is bigger than no so Yes', True),
    19 : ('TRUEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE as ngong would say (yes)', True),
    20 : ('This is the end of the dictionary and y is at the end so yes', True)
}

## takes number and returns answer based on eightball list
def getAnswer(numTimes) :
    returnList = []
    for i in range(numTimes) :
        returnList.append(eightBall[random.randint(1, EIGHTBALL_LENGTH)])
        ## print(returnList)
    return returnList
        
def shakeBall(numTimes) :
    totalCorrect = 0
    answers = getAnswer(numTimes)
    print(answers)
    for i in answers :
        if () : #checks tuple
           totalCorrect += 1
    print(str(numTimes/answers) + '%% correct')

shakeBall(10)