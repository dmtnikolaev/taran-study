global DATABASE
xpositive(string, string)
xnegative(string, string)

PREDICATES
ask(string, string)
nondeterm diagnosis(string)
it_is(string)
positive(string, string)
run
clear_facts
remember(string, string, string)

CLAUSES
run :- diagnosis(X), !, nl, write("Диагноз - "),
	write(X), write("."), nl, nl, clear_facts.
run :- nl, write("Система не может поставить диагноз."), nl, clear_facts.

positive(X, Y) :- xpositive(X, Y), !.
positive(X, Y) :- not(xnegative(X, Y)), ask(X, Y).

ask(X, Y) :- write(X), write(" "), write(Y), write("?"), nl, 
	readln(Reply), remember(X, Y, Reply).
	
remember(X, Y, "да") :- asserta(xpositive(X, Y)).
remember(X, Y, "нет") :- asserta(xnegative(X, Y)), fail.

clear_facts :- retractall(xpositive(_, _)), fail.
clear_facts :- retractall(xnegative(_, _)), fail.
clear_facts :- write("Нажмите ESC для выхода...").

it_is("Пройдена первичная дигностика") :- 
	positive("Компьютер", "подключен к сети"),
	not(positive("Бипер", "подает сигналы")).
it_is("Компьютер доходит до стадии BOOT") :-
	it_is("Пройдена первичная дигностика"),
	positive("LED_BOOT", "горит"),
	positive("BIOS", "включается").
it_is("Компьютер НЕ доходит до стадии BOOT") :-
	it_is("Пройдена первичная дигностика"),
	not(positive("LED_BOOT", "горит")),
	not(positive("Кулер", "включается")).
	
diagnosis("Неисправность БП") :- 
	it_is("Компьютер НЕ доходит до стадии BOOT"),
	positive("LED_CPU и LED_RAM", "горят"),
	not(positive("БП", "работает в другом компьютере")),
	not(positive("БП", "работает отдельно")).
diagnosis("Ошибка подключения CPU или RAM") :-
	it_is("Компьютер НЕ доходит до стадии BOOT"),
	not(positive("LED_CPU и LED_RAM", "горят")),
	positive("CPU", "работает в другом компьютере"),
	positive("RAM", "работает в другом компьютере").
diagnosis("Неисправность HDD") :- 
	it_is("Компьютер доходит до стадии BOOT"),
	not(positive("HDD", "отображается в BIOS")),
	positive("HDD", "установлена ОС"),
	not(positive("HDD", "работает в другом компьютере")).
diagnosis("Неисправность ОС") :-
	it_is("Компьютер доходит до стадии BOOT"),
	positive("HDD", "отображается в BIOS"),
	positive("ОС", "возникает синий экран или kernel panic"),
	positive("ОС", "код ошибки указывает на внутреннюю ошибку").
GOAL
run.