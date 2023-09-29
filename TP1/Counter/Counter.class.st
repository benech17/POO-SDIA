Class {
	#name : #Counter,
	#superclass : #Object,
	#instVars : [
		'count'
	],
	#category : #Counter
}

{ #category : #accessing }
Counter >> count [ 
	"getterMethod: "

	^ count 
]

{ #category : #accessing }
Counter >> count: anInteger [
	"setterMethod: "
	count := anInteger 
]

{ #category : #accessing }
Counter >> decrement [ 
	count := count -1
]

{ #category : #accessing }
Counter >> increment [ 
	count := count +1
]
