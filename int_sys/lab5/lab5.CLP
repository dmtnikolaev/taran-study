(deftemplate block
	(slot size (type INTEGER))
	(slot place (type SYMBOL))
	(slot color (type SYMBOL))
)

(deftemplate on
	(slot upper (type SYMBOL))
	(slot lower (type SYMBOL))
	(slot place (type SYMBOL)(default heap))
)

(deftemplate goal
	(slot current-task (type SYMBOL))
)

;; Variant #3
(deffacts init
	(block (size 15)(color yellow)(place heap))
	(block (size 10)(color red)(place heap))
	(block (size 25)(color white)(place heap))
	(block (size 5)(color brown)(place heap))
)

(defrule init-system
	(initial-fact) 
=> 
	(assert (goal (current-task find)))
)

(defrule find-biggest
	?current-goal <- (goal (current-task find))
	?current-block <- (block (size ?current-size)(place heap))
	(not (block (size ?bigger-size&:(> ?bigger-size ?current-size))(place heap)))
=>
	(modify ?current-goal (current-task build))
	(modify ?current-block (place hand))
)

(defrule build-first
	?current-goal <- (goal (current-task build))
	?current-block <- (block (place hand))
	(not (block (place tower)))
=>
	(modify ?current-goal (current-task find))
	(modify ?current-block (place tower))
	(assert (on (place tower)))
)

(defrule build-next
	?current-goal <- (goal (current-task build))
	?current-block <- (block (color ?current-color)(place hand))
	(block (color ?tower-upper-color)(place tower))
	(not (on (upper ?x)(lower ?tower-upper-color)))
=>
	(modify ?current-goal (current-task find))
	(modify ?current-block (place tower))
	(assert (on (upper ?current-color)(lower ?tower-upper-color)(place tower)))
)

(defrule stop
	?current-goal <- (goal (current-task find))
	(not (block (place heap)))
=>
	(retract ?current-goal)
)