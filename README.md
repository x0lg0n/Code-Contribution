# Hacktoberfest 2024 & Hacksquad 2024
<br>
<p>HacktoberFest Hello World in every other language ever. Just fork it and add a 'Hello World' program to contribute for hacktober fest and send a Pull Request!!</p>
<h4>Get yourself free goodies by just writing a hello world!</h4>


### Don't forgot to star this reposetory.
# What is hacksquad?
HackSquad allows contributors to contribute code as a squad instead of a single contributor. Engage the community in a friendly competition over the month of October.

<h1>What is hactoberfest?</h1>
<p>Hacktoberfest is an annual event that encourages contributions to open-source projects on platforms like GitHub. It takes place throughout the month of October. The main goal of Hacktoberfest is to promote open-source collaboration and community participation by rewarding contributors with limited-edition swag, such as t-shirts and stickers, for making a certain number of valid pull requests to open-source repositories.</p>


## Steps to follow :scroll:

### 1. Register for Hacktoberfest and Hacksquad 2024

https://hacktoberfest.digitalocean.com/

https://www.hacksquad.dev/

### 2. Fork it :fork_and_knife:

You can get your own fork/copy of [Hacktoberfest](https://github.com/shivaylamba/Hacktoberfest) by using the <kbd><b>Fork</b></kbd></a> button or clicking [this](https://github.com/shivaylamba/Hacktoberfest/).

[![Fork Button]](https://github.com/x0lg0n/Code-Contribution)

### 3. Add a Program in any Language you like :rabbit2:

Once you have forked the repo, add your progam in the language folder in main branch, if there is no language folder, make one, then add into it.
You can take a look to the [Programming Language List](https://en.wikipedia.org/wiki/List_of_programming_languages) in Wikipedia to create a new one for Hacktoberfest!

### 4. Ready, Steady, Go... :turtle: :rabbit2:

Once you have completed these steps, you are ready to start contributing
by checking our `Help Wanted` issues and creating [pull requests](https://github.com/x0lg0n/Code-Contribution/pulls).

### 5. Give this Project a Star :star:

If you liked working on this repo, please share this repo as much
as you can and star this repo to help as many people in opensource as you can.

# Steps to Make Changes and contribute using GIT!

To make your own local copy of the repository you would like to contribute to, let’s first open up a terminal window.

We’ll use the `git clone` command along with the URL that points to your fork of the repository.

This URL will be similar to the URL above, except now it will end with `.git` . In the cloud_haiku example above, the URL will look like this:

https://github.com/your-username/Hacktoberfest.git

You can alternatively copy the URL by using the green “Clone or download” button from your repository page that you just forked from the original repository page. Once you click the button, you’ll be able to copy the URL by clicking the binder button next to the URL:

Once we have the URL, we’re ready to clone the repository. To do this, we’ll combine the `git clone` command with the repository URL from the command line in a terminal window:

```
git clone (https://github.com/your-username/Code-Contribution.git)
```

### 4. Create a New Branch

To create your branch, from your terminal window, change your directory so that you are working in the directory of the repository. Be sure to use the actual name of the repository (i.e. Hacktoberfest) to change into that directory.

```
cd Code-Contribution
```

Now, we’ll create our new branch with the `git branch` command. Make sure you name it descriptively so that others working on the project understand what you are working on.

```
git branch new-branch
```

Now that our new branch is created, we can switch to make sure that we are working on that branch by using the git checkout command:

```
git checkout new-branch
```

Once you enter the git checkout command, you will receive the following output:

```
Output:

Switched to branch 'new-branch'
```

At this point, you can now modify existing files or add new files to the project on your own branch.

#### Make Changes Locally

Once you have modified existing files or added new files to the project, you can add them to your local repository, which you can do with the `git add` command. Let’s add the `-A` flag to add all changes that we have made:

```
git add -A
```

or

```
git add .
```

Next, we’ll want to record the changes that we made to the repository with the git commit command.

The commit message is an important aspect of your code contribution; it helps the other contributors fully understand the change you have made, why you made it, and how significant it is. Additionally, commit messages provide a historical record of the changes for the project at large, helping future contributors along the way.

If you have a very short message, you can record that with the `-m` flag and the message in quotes:

Example:

```
git commit -m "Updated Readme.md"
```

At this point you can use the `git push` command to push the changes to the current branch of your forked repository:

Example:

```
git push --set-upstream origin new-branch
```

### 5. Update Local Repository

While you are working on a project alongside other contributors, it is important for you to keep your local repository up-to-date with the project as you don’t want to make a pull request for code that will cause conflicts. To keep your local copy of the code base updated, you’ll need to sync changes.

We’ll first go over configuring a remote for the fork, then syncing the fork.

### 6. Configure a Remote for the Fork

Next, you’ll have to specify a new remote upstream repository for us to sync with the fork. This will be the original repository that you forked from. You’ll have to do this with the `git remote add` command.

```
git remote add upstream https://github.com/your-username/Code-Contribution.git
```

In this example, `upstream` is the shortname we have supplied for the remote repository since in terms of Git, “upstream” refers to the repository that you cloned from. If you want to add a remote pointer to the repository of a collaborator, you may want to provide that collaborator’s username or a shortened nickname for the shortname.

### 7. Sync the Fork

Once you have configured a remote that references the upstream and original repository on GitHub, you are ready to sync your fork of the repository to keep it up-to-date.

To sync your fork, from the directory of your local repository in a terminal window, you’ll have to use the `git fetch` command to fetch the branches along with their respective commits from the upstream repository. Since you used the shortname “upstream” to refer to the upstream repository, you’ll have to pass that to the command:

```
git fetch upstream
```

Switch to the local master branch of our repository:

```
git checkout master
```

You’ll now have to merge any changes that were made in the original repository’s master branch, that you will access through your local upstream/master branch, with your local master branch:

```
git merge upstream/master
```

### 8. Create Pull Request

At this point, you are ready to make a pull request to the original repository.

You should navigate to your forked repository, and press the “New pull request” button on your left-hand side of the page.

Every pull request is accepted and merged. So hurry up and contribute to this repo.

# Hurray!! You just got closer to complete your hacktoberfest challenge.

## Purpose of the Repository

The purpose of this repository is to provide a platform for developers to contribute to open-source projects during Hacktoberfest and Hacksquad 2024. By adding a 'Hello World' program in any programming language, contributors can participate in these events, learn about different programming languages, and collaborate with the community.

## How to Contribute

1. **Fork the repository** to your own GitHub account.
2. **Clone your forked repository** to your local machine:

   ```bash
   git clone https://github.com/your-username/Code-Contribution.git
   ```

3. **Create a new branch** for your contribution:

   ```bash
   git checkout -b feature/your-feature-name
   ```

4. **Add your 'Hello World' program** in the appropriate language directory. If the directory does not exist, create one.

5. **Commit your changes** with a descriptive commit message:

   ```bash
   git commit -m "Add Hello World in [Language]"
   ```

6. **Push your branch** to your forked repository:

   ```bash
   git push origin feature/your-feature-name
   ```

7. **Open a Pull Request** to the main branch of this repository with a descriptive title and summary of your changes.

8. **Wait for review and approval**. Once your pull request is approved, it will be merged into the main branch.

### Example Contributions

Here are some examples of 'Hello World' programs in different programming languages:

#### Python

```python
print("Hello, World!")
```

#### JavaScript

```javascript
console.log("Hello, World!");
```

#### C++

```cpp
#include <iostream>
int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
```

Feel free to explore the repository and see more examples in various languages. Happy contributing!
