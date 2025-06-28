function retrieveReviews() {
    const [title, setTitle] = React.useState('');
    const [reviews, setReviews] = React.useState([]);
    const [error, setError] = React.useState('');
    const [searched, setSearched] = React.useState(false);

    const retrieveReviewsByTitle = async (title) => {
        try {
            setSearched(true);
            if (title === '') {
                const response = await fetch('/reviews/retrieve', {
                    method: 'GET',
                    headers: {
                        'Accept': 'application/json'
                    }
                });
                const data = await response.json();
                setReviews(data || []);
            } else {
                const response = await fetch('/reviews/retrieve', {
                    method: 'POST',
                    headers: {
                        'Content-type': 'application/json',
                        'Accept': 'application/json'
                    },
                    body:  JSON.stringify({
                        title: title
                    }),
                });
                const data = await response.json();
                setReviews(data || []);
            }
        } catch (error) {
            setReviews([]);
            setSearched(true);
        }
    }

    return React.createElement('div', null,
        React.createElement('h1', null, 'Retrieve Reviews'),
        React.createElement('p', null, 'Enter the name of the book you want to retrieve or click Retrieve all'),
        React.createElement('input',
            {
                value: title,
                onChange: event => setTitle(event.target.value),
                placeholder: "Title",
                style: {marginRight: '10px'}
            }),
        React.createElement('button', {onClick: () => {
            if (title.trim() === '') {
                setError('Please enter a title');
                return;
            }
            setError('');
            retrieveReviewsByTitle(title);
        }}, 'Retrieve'),
        React.createElement('button', {onClick: () => {
            setError('');
            retrieveReviewsByTitle('');
        }}, 'Retrieve All'),
        error ? React.createElement('p', {style: {color: 'red'}}, error) : null,
        searched ? (
            reviews.length > 0 ? 
                React.createElement('ul', null,
                    reviews.map((review, index) => 
                        React.createElement('li', {key: index}, 
                            React.createElement('div', null,
                                React.createElement('strong', null, review.title),
                                React.createElement('p', null, `Rating: ${review.rating}`),
                                React.createElement('p', null, review.description),
                                React.createElement('p', null, review.created)
                            )
                        )
                    )
                ) : 
                React.createElement('p', null, 'No reviews found')
        ) : null
    );
}

ReactDOM.render(React.createElement(retrieveReviews), document.getElementById('root'));
