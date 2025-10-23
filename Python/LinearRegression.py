"""
Linear Regression Example

This script demonstrates a simple linear regression using scikit-learn.
It fits a model to sample data and predicts the output for a given input.
"""

# Import necessary libraries

import pandas as pd
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split
import numpy as np



# Sample data
np.random.seed(42)
X = np.random.rand(100, 1) * 10
y = (10 * X + np.random.randn(100, 1) * 15).flatten()

# Create a DataFrame
df = pd.DataFrame({'x': X.flatten(), 'y': y})





# Define features (X) and target variable (Y)
X = df[['x']]  # Features must be in 2D array format
Y = df['y']    # Target variable
X_train,X_test,y_train,y_test = train_test_split(X,Y,test_size = 0.25,random_state = 42) #split the data to avoid overfitting and for effective predictions

# Create a LinearRegression model instance
model = LinearRegression()

# Fit the model to the data
model.fit(X_train, y_train)


# Make predictions for on test data
prediction = model.predict(X_test)

#visualize the linear regression model using scatter plots
plt.scatter(X_train, y_train, color='blue', label='Training Data')
plt.scatter(X_test, y_test, color='red', label='Testing Data')
plt.plot(X, model.predict(X), color='green', linewidth=2, label='Regression Line')
plt.xlabel('X')
plt.ylabel('Y')
plt.legend(
plt.show()

#View the accuracy of predictions
prediction_df = pd.DataFrame({'Actual': y_test, 'Predicted': prediction})
prediction_df = prediction_df.reset_index(drop=True)

print("\n The predicted values are:")
print(prediction_df)

# Predict for any x = num
x = 9
pred_value = model.predict([[x]])
print("the predicted value for", x," is:",pred_value)
