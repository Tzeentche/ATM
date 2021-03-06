# language: ru
@withdrawal
Функция: Тестирование информации в всплывающих элементах в "Онлайнере"

  @success
  Сценарий: Проверить наличие подменю у элемента "Автобарахолка" с корректными категориями
    Когда Пользователь наводит курсор мыши на пункт "Автобарахолка"
    Тогда Появляется подменю
    Тогда подменю отображает категорию "деление по ценам"
    Тогда подменю отображает категорию "деление по городам"
    Тогда подменю отображает категорию "деление по маркам"

  @success
  Сценарий: Проверить наличие подменю у элемента "Дома и квартиры" с корректными категориями
    Когда Пользователь наводит курсор мыши на пункт "Дома и квартиры"
    Тогда Появляется подменю
    Тогда подменю отображает категорию "города"
    Тогда подменю отображает категорию "количество комнат"
    Тогда подменю отображает категорию "ценовой диапазон"