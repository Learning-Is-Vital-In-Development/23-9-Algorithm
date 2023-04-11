def solution(phone_book):
    phone_number_set = set(phone_book)

    for phone_number in phone_number_set:
        for i in range(1, len(phone_number) + 1):
            prefix = phone_number[:i]
            if prefix in phone_number_set and phone_number != prefix:
                return False

    return True
