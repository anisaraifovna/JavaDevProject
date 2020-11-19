# Моделирование снятия наличных в банкомате
  
  * Банкомат 
  * Кассета
  * Купюра
  * Банковская карта/телефон с NFC
  * Пин-код 
  * Номер карты 
  * Дата действия карты 
  * QR-код 
  * Одноразовый пароль
  * Банк (процессинговый центр)
  * Транзакция
  * Счет
  * Карты, привязанные к счету
  * Баланс
  * Сумма снятия
  * Валюта снятия
  * Чек
  * Сессия на банкомате(?)
  * Токен для доступа к Счету (?)
  * Пользователь (не рассматривается)
  * Карта
  
  
  ##Сценарии:
  
**Сценарий с картой № 1**
* Пользователь вставляет/прикладывает банковскую карту, вводит пин-код, сумму и валюту для снятия  (-) *вызов метода объекта Банкомат*
* Банкомат отправляет запрос на снятие в Банк
* Банк проверяет данные авторизации
* Банк проверяет баланс и сумму, отправляет одобрение, изменяет баланс(1)
* Банкомат выбирает из кассет нужные Купюры (1) 
* Пользователь забирает Купюры (-)
    
**Сценарий QR-кодом** (4)		
* Пользователь сканирует QR-код и вводит одноразовый пароль для QR-кода *вызов метода объекта Банкомат*
* Банкомат отправляет запрос авторизации и валидации кода в Банк
* Банк отправляет Банкомату сумму и валюта снятия
* Банкомат выбирает из кассет нужное количество Купюр 
* Банкомат отправляет успех банку
* Банк делает недействительным код 
* Банкомат печатает чек
* Пользователь забирает Купюры и Чек 

**Сценарий с картой №2 **
* Пользователь вставляет/прикладывает банковскую карту/телефон с NFC и вводит пин-код (-) *вызов метода объекта Банкомат*
* Банкомат отправляет запрос авторизации в Банк (2)
* Банк проверяет данные авторизации и считает количество неудачных попыток ввода пин-кода
* Банк возвращает токен (?) (2)	
* Пользователь выбирает снятие наличных (-) *вызов метода объекта Банкомат*
* Банкомат проверяет возможность выдачи наличных (наличие купюр в целом) и чему может быть кратная сумма (3)
* Пользователь вводит сумму и валюту для снятия (1)
* Банкомат вычисляет возможно ли выдать данную сумму с учетом Купюр в наличии (3)
* Банкомат делает запрос в Банк на снятие (1)
* Банк блокирует Счет для однопользовательского доступа (?) 
* Банк проверяет текущий баланс и сумму и отправляет отобрение, изменяет баланс (1)
* Банкомат выбирает из кассет нужные Купюры (1) 
* Банкомат отправляет результат Банку (1)
* Банкомат делает запрос остатка для печати чека 
* Банкомат печатает чек (2)
* Пользователь забирает Купюры и Чек (-)
* Банкомат закрывает Сессию(2)