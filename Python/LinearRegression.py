"""
Linear Regression Example

This script demonstrates a simple linear regression using scikit-learn.
It fits a model to sample data and predicts the output for a given input.
"""

# Import necessary libraries
import pandas as pd
from sklearn.linear_model import LinearRegression

# Sample data
data = {
    'x': [1, 2, 3, 4, 5, 6],
    'y': [10, 20, 30, 40, 50, 60]
}

# Create a DataFrame from the sample data
df = pd.DataFrame(data)
print(df)

# Define features (X) and target variable (Y)
X = df[['x']]  # Features must be in 2D array format
Y = df['y']    # Target variable

# Create a LinearRegression model instance
model = LinearRegression()

# Fit the model to the data
model.fit(X, Y)

# Make predictions for a new value
num = 9
num_actual = 90   # Expected output for demonstration
print(f'\nFor x = {num}, actual y = {num_actual}')

# Predict y for x = num
num_pred = model.predict([[num]])
print(f'For x = {num}, predicted y = {num_pred[0]}')