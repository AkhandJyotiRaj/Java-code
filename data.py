import pandas as pd
import numpy as np
from faker import Faker
import random
from datetime import date, timedelta


fake = Faker()

data = []

def get_random_date(start_date, end_date):
    """
    Returns a random date between start_date and end_date.
    """
    delta = end_date - start_date
    int_delta = (delta.days * 24 * 60 * 60) + delta.seconds
    random_second = random.randrange(int_delta)
    return start_date + timedelta(seconds=random_second)

start_date = date(2025, 1, 1)
end_date = date(2025, 12, 31)


for i in range(2000):
    gender = random.choice(['Male', 'Female'])
    name = fake.name_male() if gender == 'Male' else fake.name_female()
    age = np.random.randint(18, 65)  # Ages between 18 and 65
    date_assigned = get_random_date(start_date, end_date)
    
    data.append([i + 1, name, age, gender, date_assigned])

df = pd.DataFrame(data, columns=['ID', 'Name', 'Age', 'Gender', 'Date Assigned'])

print(df.head(10))

print("\nDataFrame Info:")
print(df.info())