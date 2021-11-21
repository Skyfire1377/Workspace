timer = {startTime=0, finishTime=0, resultTime=0}
function timer:start()
	self.startTime = os.clock()	
end
function timer:finish()
	self.endTime = os.clock()
end
function timer:result()
	return self.endTime - self.startTime
end
return timer
