CPATH='.;/../lib/hamcrest-core-1.3.jar;../lib/junit-4.13.2.jar'

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone $1 student-submission
echo 'Finished cloning'

if [ $(find student-submission/ -name "ListExamples.java") = "student-submission/ListExamples.java" ]
then
    echo 'found'
    cp -r student-submission/ListExamples.java grading-area/
    cp TestListExamples.java grading-area/
    cd grading-area
    javac -cp $CPATH *.java
    echo $?
    if [ $? == 0 ]
    then
        java -cp $CPATH org.junit.runner.JUnitCore TestListExamples
        if [ $? == 0 ]
        then
            echo "Sucess!"
        else
            echo "Failed test"
        fi
    else
        echo "failed compilation error"
    fi
else 
    echo 'not found'
    echo 'instead found'
    found= find student-submission/ -name "ListExamples.java"
    echo $found
fi

# Draw a picture/take notes on the directory structure that's set up after
# getting to this point

# Then, add here code to compile and run, and do any post-processing of the
# tests
