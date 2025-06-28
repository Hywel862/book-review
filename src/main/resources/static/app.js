function app() {
    return React.createElement('div', null,
        React.createElement('button', {
            type: 'button',
            onClick: () => window.location.href = 'create-review.html',
            style: {display: 'block', marginBottom: '10px'}
        }, 'Create a review'),

        React.createElement('button', {
            type: 'button',
            onClick: () => window.location.href = 'retrieve-reviews.html',
            style: {display: 'block', marginBottom: '10px'}
        }, 'Retrieve reviews')
    );
}
ReactDOM.render(React.createElement(app), document.getElementById('root'));
